import java.io.*;
import java.net.*;
import java.util.*;

import org.json.simple.*;
import org.json.simple.parser.*;

public class HelloWorld{

  public static void main(String []args){

     try {
         JSONParser parser = new JSONParser();
         JSONObject json = null;
         URL url = new URL("http://api.duckduckgo.com/?q=science&format=json&pretty=0");
         URLConnection conn = url.openConnection();
         conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;     rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");

         Scanner scn = new Scanner(conn.getInputStream()).useDelimiter("\\A");
         String buffer = scn.hasNext() ? scn.next() : "";
         json = (JSONObject) parser.parse(buffer);
         System.out.println(json.toString());

     } catch (Exception e) {
         e.printStackTrace();
     }
  }
}