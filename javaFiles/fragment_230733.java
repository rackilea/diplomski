package com.javasamples;

//reading an embedded RAW data file

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;
import java.io.*;

public class FileDemo1 extends Activity {

@Override
public void onCreate(Bundle savedInstanceState) {
super.onCreate(savedInstanceState);
setContentView(R.layout.main);
try {
    PlayWithRawFiles();
} catch (IOException e) {
    Toast.makeText(getApplicationContext(), 
                 "Problems: " + e.getMessage(), 1).show();
}
  }// onCreate

public void PlayWithRawFiles() throws IOException {      
String str="";
StringBuffer buf = new StringBuffer();          
InputStream is = this.getResources().openRawResource(R.myfolder.text_file);
BufferedReader reader = new BufferedReader(new InputStreamReader(is));
if (is!=null) {                         
    while ((str = reader.readLine()) != null) { 
        buf.append(str + "\n" );
    }               
}       
is.close(); 
Toast.makeText(getBaseContext(), 
        buf.toString(), Toast.LENGTH_LONG).show();              


}// PlayWithSDFiles

} // FilesDemo4