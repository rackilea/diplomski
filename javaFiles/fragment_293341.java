package org.kodejava.example.httpclient;    

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class getEmissions {
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpPost post = new HttpPost("https://www.carbonhub.xyz/v1/emissions");

        StringBuilder requestData = new StringBuilder("'{");
        requestData.append("\"item\"").append(':').append("\"electricity\"").append(',');
        requestData.append("\"region\"").append(':').append("\"india\"").append(',');
        requestData.append("\"unit\"").append(':').append("\"kWh\"").append(',');
        requestData.append("\"quantity\"").append(':').append("1.564");
        requestData.append("}'");

        StringEntity requestDataEntity = new StringEntity(requestData.toString(),ContentType.APPLICATION_JSON);
        try {
            post.setEntity(requestData);
            // use your api key
            post.setHeader("access-key","<apikey>");
            HttpResponse response = client.execute(post);

            // Print out the response message
            System.out.println(EntityUtils.toString(response.getEntity()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}