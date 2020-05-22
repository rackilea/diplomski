package your.packagee.name;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

public class DataBaseHelper extends SQLiteOpenHelper {

private static final String pkg = "your package name";
private static String DB_PATH = "/data/data/" + pkg + "/databases/";

private static String DB_NAME = "yourDBFile.sqlite";
int[] dbfiles = { R.raw.chunk1 , R.raw.chunk2 ..... };

 private SQLiteDatabase myDataBase;
private final Context myContext;

public DataBaseHelper(Context context) {
    super(context, DB_NAME, null, 1);
    this.myContext = context;
}

public void createDataBase() {

    boolean dbExist = checkDataBase();

    if (dbExist) {
        // do nothing - database already exist
    } else {
        this.getReadableDatabase();
        try {
            CopyDataBase();
        } catch (IOException e) {
            Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT)
                    .show();
            Log.d("Create DB", e.getMessage());
        }
    }

}

private boolean checkDataBase() {
    SQLiteDatabase checkDB = null;
    try {
        String myPath = DB_PATH + DB_NAME;
        checkDB = SQLiteDatabase.openDatabase(myPath, null,
                SQLiteDatabase.NO_LOCALIZED_COLLATORS);
    } catch (SQLiteException e) {
        Toast.makeText(myContext, e.getMessage(), Toast.LENGTH_SHORT)
                .show();
        Log.d("Check DB", e.getMessage());
    }

    if (checkDB != null) {
        checkDB.close();
    }
    return checkDB != null ? true : false;
}

private void CopyDataBase() throws IOException {
    InputStream databaseInput = null;
    Resources resources = myContext.getResources();
    String outFileName = DB_PATH + DB_NAME;

    OutputStream databaseOutput = new FileOutputStream(outFileName);

    byte[] buffer = new byte[512];
    int length;

    for (int i = 0; i < dbfiles.length; i++) {
        databaseInput = resources.openRawResource(dbfiles[i]);
        while ((length = databaseInput.read(buffer)) > 0) {
            databaseOutput.write(buffer, 0, length);
            databaseOutput.flush();
        }
        databaseInput.close();
    }

    databaseOutput.flush();
    databaseOutput.close();
}

public void openDataBase() throws SQLException {
    String myPath = DB_PATH + DB_NAME;
    myDataBase = SQLiteDatabase.openDatabase(myPath, null,
            SQLiteDatabase.NO_LOCALIZED_COLLATORS);
}

@Override
public synchronized void close() {
    if (myDataBase != null)
        myDataBase.close();
    super.close();
}

@Override
public void onCreate(SQLiteDatabase db) {

}

@Override
public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

}

public boolean deleteItem (String ID){

    String query = "delete from item where id='" + ID + "'"  ;
    Log.d("Query : ", query);
    try{
        myDataBase.execSQL(query);
        return true ;
    } catch (Exception e){
        Log.d("Exception", e.toString());
        return false ;
    }
}

public Cursor getSearchFromID(String id) {
    return myDataBase.rawQuery("select * from item where id = \"" + id + "\"", null);
}

public boolean addSave(String type, String data , String time) {

    String query = "insert into item (type, data , timestamp) values ('" + type
    + "', '" + data + "', '" + time + "')"; 
try {
   myDataBase.execSQL(query);
   return true ;
} catch (Exception e) {
   return false ;
}
}
}