package com.example.test3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText msg;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        msg = (EditText) findViewById(R.id.editText);
        send = (Button) findViewById(R.id.button);

        send.setOnClickListener(this);
    }// onCreate

    @Override
    public void onClick(View v) {
        switch( v.getId() ) {
            case R.id.button: {
                new LINENotify().execute(msg.getText().toString());
                break;
            }
        }
    }

    public class LINENotify extends AsyncTask<String, Integer, String> {

        private static final String strEndpoint = "https://notify-api.line.me/api/notify";
        private static final String tokenKEY = "ldO3dTIAjT5OpjWbeZAQtnXhq23poCXcEAvKoTwJHhn";
        String result = "";

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... strings) {
            String message = strings[0];

            try {
                URL url = new URL( strEndpoint );
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();

                connection.setRequestMethod( "POST" );
                connection.addRequestProperty("Authorization",  "Bearer " + tokenKEY);
                connection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

                connection.setConnectTimeout(15*1000);
                connection.setDoOutput( true );
                connection.setUseCaches( false );

                connection.setReadTimeout(15*1000);
                connection.setDoInput( true );

                OutputStream os = connection.getOutputStream();
                OutputStreamWriter writer = new OutputStreamWriter(os, "UTF-8");

                writer.write( "message=" + message );
                writer.flush();
                writer.close();
                os.close();

                connection.connect();

                result = connection.getResponseMessage();

                connection.disconnect();
            } catch (IOException error) {
                // Handles input and output errors
            }
            return result;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}