public class DataHelper extends SQLiteOpenHelper {

public SQLiteDatabase database = null;
public File databaseFile;
public static String databaseName = "myDb";
public String databasePath = "";
Context mContext;

public DataHelper(Context paramContext) {

    super(paramContext, databaseName, null, 1);
    this.mContext = paramContext;


    this.databasePath = ("data/data/" + paramContext.getPackageName()+"/databases/"+databaseName);
    //this.databasePath = ("data/data/" + paramContext.getPackageName() + "/data.sqlite");
    this.databaseFile = new File(this.databasePath);
    if (!this.databaseFile.exists())
        try {
            deployDataBase(DataHelper.databaseName, this.databasePath);
            return;
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
}

private void deployDataBase(String dbNAme, String dbPath)
        throws IOException {
    InputStream localInputStream = this.mContext.getAssets().open(dbNAme);
    FileOutputStream localFileOutputStream = new FileOutputStream(dbPath);
    byte[] arrayOfByte = new byte[1024];
    while (true) {
        int i = localInputStream.read(arrayOfByte);
        if (i <= 0) {
            localFileOutputStream.flush();
            localFileOutputStream.close();
            localInputStream.close();
            return;
        }
        localFileOutputStream.write(arrayOfByte, 0, i);
    }
}

@Override
public synchronized void close() {

    if (database != null)
        database.close();

    super.close();

}
@Override
public void onCreate(SQLiteDatabase db) {
    // TODO Auto-generated method stub

}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    // TODO Auto-generated method stub

}

}