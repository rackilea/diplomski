public class CopyDBFromAssets {

    boolean copied = false;

    public static boolean createDataBase(Context context, String databasename) {

        boolean copied = false;

        boolean dbExist = checkDataBase(context, databasename);

        if(!dbExist) {

            // calling this method will create an empty database
            // which will hopefully be overidden, if not then
            // empty database will exist ?????????
            //this.getReadableDatabase(); <<<<< NOTE Commented out as empty db with no tables is useless
            if (!checkAssetExists(context, databasename, "")) {
                Log.e("CREATEDB", "Error getting asset " + databasename);
            } else {
                 return copyDataBase(context, databasename);
            }
            return false;
        }
        return true;
    }


    private static boolean checkAssetExists(Context context, String assetfile, String path) {
        boolean rv = false;     // assume asset file doesn't exist
        String[] assetsfound = new String[]{};
        // Get the list of assets at the given path

        try {
            assetsfound = context.getAssets().list(path);
        } catch (IOException e) {
            Log.e("CHECKASSET","IO Exception when checking for the asset file." + e.getMessage());
            return false;
        }
        // Check to see if the desired asset (passed assetfile) exists
        for (String s: assetsfound) {
            if (s.equals(assetfile)) {
                rv = true;
                break;
            }
        }
        if (rv) {
            Log.d("CHECKASSET", "Asset " + assetfile + "was found.");
        } else {
            String assetlist = "";
            for (String s: assetsfound) {
                assetlist = assetlist + " " + s;
            }
            Log.e("CHECKASSET", "Asset " + assetfile +
                    "could not be found. Assets that exists are:- " +
                    assetlist
            );
        }
        // Asset not found lets try ignoring case
        if (!rv) {
            for (String s: assetsfound) {
                if ((s.toLowerCase()).equals(assetfile.toLowerCase())) {
                    Log.e("CHECKASSET","Found asset as " + assetfile +
                            " but looking for " + s +
                            ", although they are similar the case is different."
                    );
                }
            }
        }
        return rv;
    }

    // check if database exists to avoid recopying it
    private static boolean checkDataBase (Context context, String database){
        SQLiteDatabase checkDB = null;
        String dbpath = context.getDatabasePath(database).getPath();

        try{
            checkDB = SQLiteDatabase.openDatabase(dbpath, null,
                    SQLiteDatabase.OPEN_READONLY);
        } catch(SQLiteException e){
            // database doesnt exist yet
        }

        if(checkDB !=null){
            checkDB.close();
        }
        return checkDB !=null ? true : false;
    }
    // copies db from local assets file, were it can be accessed and handled
    private static boolean copyDataBase(Context context, String  databasename)  {

        InputStream asset;
        OutputStream db;
        int bytescopied = 0;
        int length_read;
        int buffersize = 16384;
        int blockcount = 0;
        boolean rv = false;

        try {
            asset = context.getAssets().open(databasename);
        } catch (IOException e) {
            Log.e("COPYDB",
                    "IO Error opening the asset " +
                            databasename +
                            ". Error Message was " +
                            e.getMessage()
            );
            return false;
        }

        try {
            db = new FileOutputStream(context.getDatabasePath(databasename).getPath());
        }  catch (IOException e) {
            Log.e("COPYDB",
                    "IO Error opening the output file for the database with path " +
                            databasename +
                            ". error Message was " +
                            e.getMessage()
            );
            try {
                asset.close();
            } catch (IOException e2) {
                Log.e("COPYDB",
                        "IO Error closing the asset. Message was " + e2.getMessage()
                );
            }
            return false;
        }

        byte[] buffer = new byte[buffersize];
        try {
            while ((length_read = asset.read(buffer)) > 0) {
                db.write(buffer);
                bytescopied = bytescopied + length_read;
                blockcount++;
                rv = true;
            }
        } catch (IOException e) {
            Log.e("COPYDB",
                    "IO Error Copying Database. Bytes Copied = "
                            + bytescopied +
                            " in " +
                            blockcount +
                            " blocks of " +
                            buffersize
            );
        }
        Log.d("COPYDB","Succesfully copied Database " + databasename + " from the assets." +
                " Number of bytes copied = " + bytescopied +
                " in " + blockcount + " blocks of length " + buffersize
        );
        try {
            db.flush();
            db.close();
            asset.close();
        } catch (IOException e) {
            Log.e("COPYDB",
                    "IO Error flushing or closing Database or closing asset."
            );
        }
        return rv;
    }
}