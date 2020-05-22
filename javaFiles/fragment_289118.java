import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Set;

public class Request extends IntentService
{
    private URL m_url;
    private StringBuilder m_parameters;
    private HttpURLConnection m_connection;

    public Request()
    {
        super("Request");

        m_url = null;
        m_connection = null;
        m_parameters = new StringBuilder();
    }

    public void put(String key, String value)
    {
        if(m_parameters.length() != 0)
            m_parameters.append('&');

        try
        {
            m_parameters.append(URLEncoder.encode(key, "UTF-8"));
            m_parameters.append('=');
            m_parameters.append(URLEncoder.encode(value, "UTF-8"));
        }
        catch(UnsupportedEncodingException exception)
        {
            System.exit(1);
        }
    }

    private void sendRequest()
    {
        try
        {
            byte[] data = m_parameters.toString().getBytes("UTF-8");

            m_connection = (HttpURLConnection) m_url.openConnection();

            m_connection.setAllowUserInteraction(true);
            m_connection.setRequestMethod("POST");
            m_connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
            m_connection.setRequestProperty("Content-Length", String.valueOf(data.length));
            m_connection.setDoOutput(true);
            m_connection.getOutputStream().write(data);
        }
        catch(Exception exception)
        {
            System.exit(1);
        }
    }

    private String getResponse()
    {
        String response = "";

        try
        {
            if(m_connection.getResponseCode() == HttpURLConnection.HTTP_OK)
            {
                Reader reader = new BufferedReader(new InputStreamReader(m_connection.getInputStream(), "UTF-8"));

                int c;

                do {
                    c = reader.read();
                    response += (char) c;
                }
                while (c >= 0);
            }
        }
        catch(IOException exception)
        {
            System.exit(1);
        }

        m_connection.disconnect();
        return response;
    }

    protected void onHandleIntent(Intent intent)
    {
        Bundle bundle = intent.getExtras();

        Set<String> keys = bundle.keySet();

        for(String key : keys)
            put(key, bundle.getString(key));

        try
        {
            m_url = new URL(bundle.getString("url"));
        }
        catch(MalformedURLException exception)
        {
            System.exit(1);
        }

        sendRequest();
        String response = getResponse();

        Intent broadcast = new Intent();
        broadcast.setAction(ReadyActivity.ResponseReceiver.m_broadcastKey);
        broadcast.putExtra("response", response);
        sendBroadcast(broadcast);
    }
}