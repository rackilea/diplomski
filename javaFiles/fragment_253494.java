package com.test;

import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import android.app.Activity;
import android.os.Bundle;

public class TestActivity extends Activity {
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

                // Create AuthCache instance
                AuthCache authCache = new BasicAuthCache();
                // Generate BASIC scheme object and add it to the local
                // auth cache
                BasicScheme basicAuth = new BasicScheme();
                authCache.put(targetHost, basicAuth);

                // Add AuthCache to the execution context
                BasicHttpContext localcontext = new BasicHttpContext();
                localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);

                // Create request
                // You can also use the full URI http://www.google.com/
                HttpGet httpget = new HttpGet("/");
                // Execute request
                HttpResponse response = httpclient.execute(targetHost, httpget, localcontext);

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