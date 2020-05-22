package testingThings.formEncoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class Client {

    public static void main(String[] args) throws IOException {
        URL url = new URL("http", "localhost", 8080, "/jee6/EncodingTester");
        System.out.println("url: " + url);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setDoInput(true);
        connection.setDoOutput(true);
        connection.setUseCaches(false);
        connection.setRequestProperty("User-Agent", "JavaClient/7.0.2/RIIApiClient/1.0.0");
        connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        connection.setRequestMethod("POST");

        String urlString =  URLEncoder.encode("word", "UTF-8") + "=" + URLEncoder.encode("молоко", "UTF-8");

        DataOutputStream os = new DataOutputStream(connection.getOutputStream());
        BufferedWriter dataOut = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

        dataOut.write(urlString);
        dataOut.flush();
        dataOut.close();

        int responseCode = connection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            System.out.println("SUCCESS...check log");
        }
        else {
            System.out.println("Response Code: " +  responseCode);
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream(), "UTF-8"));
        String line;

        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }

    }

}