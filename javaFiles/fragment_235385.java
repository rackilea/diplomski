package com.ondrovic.downloader;

 import java.io.File;
 import java.io.FileOutputStream; 
 import java.io.InputStream;
 import java.net.HttpURLConnection;
 import java.net.URL;

 import android.app.Activity;
 import android.app.Dialog;
 import android.app.ProgressDialog;
 import android.content.Intent;
 import android.database.SQLException;
 import android.database.sqlite.SQLiteDatabase;
 import android.os.AsyncTask;
 import android.os.Bundle;
 import android.os.Environment;
 import android.util.Log;

 public class Downloader extends Activity {
SQLiteDatabase db = null;
public static final String LOG_TAG = "DOWNLOADER";
private ProgressDialog bar;
public static final int PROGRESS = 0;

File rDIR = Environment.getExternalStorageDirectory();

public String fDIR = "<location you want to store file on SD card>";
public String fNAME = "<your database.db>";
public String fURL = "<your url>";

@Override
public void onCreate(Bundle savedInstanceState) {

    super.onCreate(savedInstanceState);

    checkDB();


        //DIRExists(fDIR);
        //new Download().execute(fURL);
}

class Download extends AsyncTask <String, String, String> {

    @Override
    public void onPreExecute() {
        super.onPreExecute();
        showDialog(PROGRESS);
    }

    @Override
    protected String doInBackground(String... aurl) {

        try {
            URL url = new URL(fURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setDoOutput(true);
            con.connect();

            int fSIZE = con.getContentLength();

            FileOutputStream out = new FileOutputStream(new File(rDIR + fDIR, fNAME));

            InputStream in = con.getInputStream();

            byte[] buffer = new byte[1024];
            int len = 0;
            long total = 0;

            while ((len = in.read(buffer)) > 0) {
                total += len;
                publishProgress("" + (int)((total*100)/fSIZE));
                out.write(buffer, 0, len);
            }
            out.close();
        } catch (Exception e) {
            Log.d(LOG_TAG, e.getMessage());
        }

        return null;
    }

    protected void onProgressUpdate(String... progress) {

        Log.d(LOG_TAG, progress[0]);
        bar.setProgress(Integer.parseInt(progress[0]));
    }

    @Override
    protected void onPostExecute(String unused) {

        dismissDialog(PROGRESS);
        startActivity(new Intent(getApplicationContext(), Main.class));
        Downloader.this.finish();
    }
}

public void DIRExists(String dirName) {

    File nDIR = new File(rDIR + dirName);
    if (!nDIR.exists()) {
        nDIR.mkdirs();
    }
}

private boolean checkDB() {

    try {

        db = SQLiteDatabase.openDatabase(rDIR + fDIR + fNAME, null,
                SQLiteDatabase.OPEN_READONLY);
        db.close();
        startActivity(new Intent(getApplicationContext(), Main.class));
        Downloader.this.finish();
    } catch (SQLException sqle) {
        Log.d(LOG_TAG, sqle.getMessage());
        DIRExists(fDIR);
        new Download().execute(fURL);
    }

    return db != null;
}

@Override
protected Dialog onCreateDialog(int id) {
    switch (id) {
    case PROGRESS:
        bar = new ProgressDialog(this);
        bar.setTitle("Database");
        bar.setMessage("Downloading database...");
        bar.setIndeterminate(false);
        bar.setMax(100);
        bar.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        bar.setCancelable(false);
        bar.show();

        return bar;
    default:
        return null;
    }
}
}