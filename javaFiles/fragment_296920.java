import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JsonReader {



  public static void main(String[] args) throws ParseException  {


            InputStream inputStream = null;
            String json = "";

            try {           
                HttpClient client = new DefaultHttpClient();  
                HttpPost post = new HttpPost("https://maps.googleapis.com/maps/api/geocode/json?address=10115,germany");
                HttpResponse response = client.execute(post);
                HttpEntity entity = response.getEntity();
                inputStream = entity.getContent();
            } catch(Exception e) {
            }

            try {           
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"),8);
                StringBuilder sbuild = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    sbuild.append(line);
                }
                inputStream.close();
                json = sbuild.toString();               
            } catch(Exception e) {
            }


            //now parse
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(json);
            JSONObject jb = (JSONObject) obj;

            //now read
            JSONArray jsonObject1 = (JSONArray) jb.get("results");
            JSONObject jsonObject2 = (JSONObject)jsonObject1.get(0);
            JSONObject jsonObject3 = (JSONObject)jsonObject2.get("geometry");
            JSONObject location = (JSONObject) jsonObject3.get("location");

            System.out.println( "Lat = "+location.get("lat"));
            System.out.println( "Lng = "+location.get("lng"));


        }
    }