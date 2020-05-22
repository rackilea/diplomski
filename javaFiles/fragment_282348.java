import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Calendar;

import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Button mailb = (Button)findViewById(R.id.bmail);
    final TextView confirmation = (TextView)findViewById(R.id.Confirmation);
    mailb.setOnClickListener(new View.OnClickListener() {   
    @Override

    public void onClick(View v) {
        try {     
            PrintWriter osw = new PrintWriter(Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).toString() + "/output.txt"); //This creates a file in my public download directory
               osw.println("Output Log: Report Tool");
               osw.println("Date: " + java.text.DateFormat.getDateTimeInstance().format(Calendar.getInstance().getTime())); 
               osw.println("------------------------------------");
               osw.println("Manufacturer: " + android.os.Build.MANUFACTURER);
               osw.println("Model: " + android.os.Build.MODEL);
               osw.println("Serial: " + android.os.Build.SERIAL);
               osw.println("BootLoader: " + android.os.Build.BOOTLOADER);
               osw.println("Build ID: " + android.os.Build.FINGERPRINT);
               osw.println("------------------------------------");
              try { 
                  Process p = Runtime.getRuntime().exec("logcat -d -v long"); //This gets the dump of everything up to the button press
                  BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
                  String line = null;
                  while ((line = reader.readLine()) != null) {
                    if(line.toString().contains("SIP_MESSAGE")){ //This parses out everything but SIP Messages
                    osw.println(line); }}}
              catch (IOException e1) {confirmation.setText(e1.getMessage()); }

               osw.flush();
               osw.close();

        } catch(Exception e){ confirmation.setText(e.getMessage()); }

        String attach = Environment.getExternalStoragePublicDirectory(DOWNLOAD_SERVICE).getAbsolutePath() + "/output.txt"; //This is where you need to use the absolute path!!
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("message/rfc822");
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"MyEmail@Email.com"});
        i.putExtra(Intent.EXTRA_SUBJECT, "Error Report.");
        i.putExtra(Intent.EXTRA_TEXT   , "Please see the attached file...");
        i.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + attach)); //This is where you attach the file 
        try {
            startActivity(Intent.createChooser(i, "Send mail..."));}
        catch (android.content.ActivityNotFoundException ex) {
            confirmation.setText("There is no Email Client installed on this device.");}                
    }
});
}
@Override
public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}

}