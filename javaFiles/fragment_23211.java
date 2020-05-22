package ca.waddlesoft.smpclient_android;

import java.net.MalformedURLException;
import java.net.URL;

import ca.waddlesoft.smpclient_android.R;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity {
    private TextView tv;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = (TextView)findViewById(R.id.TextView01);

        SmpProcessor task = new SmpProcessor();
        task.execute();
    }

  private class SmpProcessor extends AsyncTask <Void,Void,String> {

            @Override
            protected String doInBackground(Void... voids){
                URL url = null;
                try {
                    url = new URL("http://secure.g4apps.com");
                    String app="A1";
                    String data = "E1,E1,AT333AT333,9055627513,2012-02-02 02:02:02,2012-02-02 02:02:02,-454545.343434,434343.232323,A334A334A334A443X,1000000,3434";
//                  byte [] databyte=data.getBytes();
                    String out = SmpClass.smpCall(url,app,data);
//                  String out = new String(smpresponse);
                    return out;
                } catch (MalformedURLException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                return null;
            }
            @Override
            protected void onPostExecute(String result) {
                    tv.setText(result);
            }
        }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


}