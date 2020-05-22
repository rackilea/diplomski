package com.example.fileio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.widget.TextView;

public class FilioActivity extends Activity {

    private TextView tv;
    private static final String TAG = "MEDIA";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        tv = (TextView) findViewById(R.id.TextView01);

        CreateExternalLogFile("I am adding something into the text file!");
    }

private void CreateExternalLogFile(String s){
    File sdCard = Environment.getExternalStorageDirectory();
    File dir = new File (sdCard.getAbsolutePath());
    dir.mkdirs();
    File file = new File(dir, "filename.txt");
    tv.append("\nExternal file system root: "+ dir);
    try {
        FileOutputStream f = new FileOutputStream(file,false); //True = Append to file, false = Overwrite
        PrintStream p = new PrintStream(f);
        p.print(s);
        p.close();
        f.close();


    } catch (FileNotFoundException e) {
        e.printStackTrace();
        Log.i(TAG, "******* File not found. Did you" +
                        " add a WRITE_EXTERNAL_STORAGE permission to the manifest?");
    } catch (IOException e) {
        e.printStackTrace();
    }   
    tv.append("\nFile written to \n"+file);


}
}