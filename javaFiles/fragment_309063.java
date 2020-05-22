package com.stackoverflow.q2633002;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

public class Test {

    public static void main(String... args) throws IOException {
        System.out.println("Connecting...");
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet("http://apache.cyberuse.com/httpcomponents/httpclient/binary/httpcomponents-client-4.0.1-bin.zip");
        HttpResponse response = client.execute(get);

        InputStream input = null;
        OutputStream output = null;
        byte[] buffer = new byte[1024];

        try {
            System.out.println("Downloading file...");
            input = response.getEntity().getContent();
            output = new FileOutputStream("/tmp/httpcomponents-client-4.0.1-bin.zip");
            for (int length; (length = input.read(buffer)) > 0;) {
                output.write(buffer, 0, length);
            }
            System.out.println("File successfully downloaded!");
        } finally {
            if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
            if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
        }
    }

}