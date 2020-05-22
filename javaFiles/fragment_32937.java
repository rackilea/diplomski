package com.example.App;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import android.widget.EditText;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity implements OnClickListener{

    Button btnGetInfo;
    TextView textView;
    EditText editTextValue;

    public String givenValue;

    public String URL;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

      findViewsById();

        btnGetInfo.setOnClickListener(this);
    }

    private void findViewsById() {
        btnGetInfo = (Button) findViewById(R.id.buttonGetInfo);
        textView = (TextView) findViewById(R.id.textView);
        editTextValue = (EditText) findViewById(R.id.editTextValue);
    }

    public void onClick(View view) {
            givenValue = editTextValue.getText().toString();
            URL = "http://example.com/script.php?value=" + givenValue;
            GetXMLTask task = new GetXMLTask();
            task.execute(new String[] {URL});
    }

    private class GetXMLTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            String output = null;
            for (String url : urls) {
                output = getOutputFromUrl(url);
            }
            return output;
        }

        private String getOutputFromUrl(String url) {
            String output = null;
            try {
                DefaultHttpClient httpClient = new DefaultHttpClient();
                HttpGet httpGet = new HttpGet(url);

                HttpResponse httpResponse = httpClient.execute(httpGet);
                HttpEntity httpEntity = httpResponse.getEntity();
                output = EntityUtils.toString(httpEntity);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ClientProtocolException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return output;
        }

        @Override
        protected void onPostExecute(String output) {
            textView.setText(output);
        }
    }
}