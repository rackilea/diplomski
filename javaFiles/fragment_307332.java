import java.net.*;
    import java.io.*;
    import org.json.*;
    import java.net.URLConnection;
    import java.util.Scanner;
    import java.net.URL;
    import javax.swing.*;


    public class Test {

    public static void main(String[] args)throws IOException,   JSONException{//Beginning of class
        // TODO Auto-generated method stub
        String appID = "YWT4UP-Y9W7AREAHJ";
        String search = "bird";

        URL wolframData = new URL("http://api.wolframalpha.com/v2/query?input="+search+"&appid="+appID);

        URLConnection connection = wolframData.openConnection();

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        //reads in the data
        String xmlDoc;
    StringBuilder sb = new StringBuilder();
        while((xmlDoc = in.readLine()) != null) { //converts buffer reader to string
        System.out.println(xmlDoc);
    sb.append(xmlDoc);
    }
        in.close();

       JSONObject jsonDoc = (JSONObject) XML.toJSONObject(sb.toString());



    }//End of method

    }//End of class