package com.jai.http;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpExample {

    /**
     * @param args
     */
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://www.google.com/?q=java");
        try {
            HttpResponse response = client.execute(request);
            System.out.println(response.getStatusLine());

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}