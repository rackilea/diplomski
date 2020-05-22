/**** @author RAJESH Kharche */
//open Netbeans
//Choose Java->prject
//name it GoogleSearchAPP

package googlesearchapp;

import java.io.*;
import java.net.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GoogleSearchAPP {
    public static void main(String[] args) {
        try {
            // TODO code application logic here

            final int Result;

            Scanner s1=new Scanner(System.in);
            String Str;
            System.out.println("Enter Query to search: ");//get the query to search
            Str=s1.next();
            Result=getResultsCount(Str);

            System.out.println("Results:"+ Result);
        } catch (IOException ex) {
            Logger.getLogger(GoogleSearchAPP.class.getName()).log(Level.SEVERE, null, ex);
        }      
    }

    private static int getResultsCount(final String query) throws IOException {
        final URL url;
        url = new URL("https://www.google.com/search?q=" + URLEncoder.encode(query, "UTF-8"));
        final URLConnection connection = url.openConnection();

        connection.setConnectTimeout(60000);
        connection.setReadTimeout(60000);
        connection.addRequestProperty("User-Agent", "Google Chrome/36");//put the browser name/version

        final Scanner reader = new Scanner(connection.getInputStream(), "UTF-8");  //scanning a buffer from object returned by http request

        while(reader.hasNextLine()){   //for each line in buffer
            final String line = reader.nextLine();

            if(!line.contains("\"resultStats\">"))//line by line scanning for "resultstats" field because we want to extract number after it
                continue;

            try{        
                return Integer.parseInt(line.split("\"resultStats\">")[1].split("<")[0].replaceAll("[^\\d]", ""));//finally extract the number convert from string to integer
            }finally{
                reader.close();
            }
        }
        reader.close();
        return 0;
    }
}