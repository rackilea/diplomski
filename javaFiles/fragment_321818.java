package com.app.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;

public class RestClientTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        CloseableHttpClient httpClient = null;
        HttpPost httpPost = null;
        CloseableHttpResponse response = null;

        try {

            httpClient = HttpClients.createDefault();
            httpPost = new HttpPost("https://api.kii.com/api/oauth2/token");

            List<NameValuePair> nvps = new ArrayList<NameValuePair>();
            nvps.add(new BasicNameValuePair("content-type", "application/json"));
            nvps.add(new BasicNameValuePair("x-kii-appid", "xxxxx"));
            nvps.add(new BasicNameValuePair("x-kii-appkey", "xxxxxxxxxxxxxx"));

             StringEntity input = new StringEntity("{\"username\": \"dummyuser\",\"password\": \"dummypassword\"}");
             input.setContentType("application/json");
             httpPost.setEntity(input);

            for (NameValuePair h : nvps)
            {
                httpPost.addHeader(h.getName(), h.getValue());
            }

            response = httpClient.execute(httpPost);

            if (response.getStatusLine().getStatusCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : "
                        + response.getStatusLine().getStatusCode());
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    (response.getEntity().getContent())));

            String output;
            System.out.println("Output from Server .... \n");
            while ((output = br.readLine()) != null) {
                System.out.println(output);
            }
        } catch (MalformedURLException e) {

            e.printStackTrace();

        } catch (IOException e) {

            e.printStackTrace();

        } finally {
            try{
                response.close();
                httpClient.close();
            }catch(Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}