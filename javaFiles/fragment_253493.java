package com.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.os.Bundle;

public class Test2aActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        try {
            HttpHost targetHost = new HttpHost("www.google.com", 80, "http");

            DefaultHttpClient httpclient = new DefaultHttpClient();
            try {
                // Store the user login
                httpclient.getCredentialsProvider().setCredentials(
                        new AuthScope(targetHost.getHostName(), targetHost.getPort()),
                        new UsernamePasswordCredentials("user", "password"));

                // Create request
                // You can also use the full URI http://www.google.com/
                HttpGet httpget = new HttpGet("/");
                // Execute request
                HttpResponse response = httpclient.execute(targetHost, httpget);

                HttpEntity entity = response.getEntity();
                System.out.println(EntityUtils.toString(entity));
            } finally {
                httpclient.getConnectionManager().shutdown();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}