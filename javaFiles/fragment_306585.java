import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;
//  
public class Connector extends AsyncTask<TextView, Void, String> {

    @Override
    protected String doInBackground(TextView... params) {
        // TODO Auto-generated method stub
        return GetSomething();
    }

    private final String getSomething() {   
         try{
                url=new URL("http://www.dynamiskdesign.se/ipromotionnew/json/148.json");
                HttpURLConnection httpURLConnection=(HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("GET");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.connect();
                InputStream input=httpURLConnection.getInputStream();

        } catch(Exception e) {
                Log.e("log_tag", "Error in http connection " + e.toString());
        }

        //convert response to string
        try{
                if (input != null) 
                {
                    writer = new StringWriter();
                    char[] buffer = new char[1024];
                    Reader reader = new BufferedReader(new InputStreamReader(input, "UTF-8"));
                    int n;
                    while ((n = reader.read(buffer)) != -1) {
                        writer.write(buffer, 0, n);
                    }
                    input.close();
                }

        } catch(Exception e) {
                Log.e("log_tag", "Error converting result "+e.toString());
        }
        //parse json data
        try {
                String jsontext = writer.toString();

        } catch(JSONException e) {
                Log.e("log_tag", "Error parsing data "+e.toString());
        }
        return returnString; 
    }    

    protected void onPostExecute(String page) {   
        //onPostExecute
    }   
}