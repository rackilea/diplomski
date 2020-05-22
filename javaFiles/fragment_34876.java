package so;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document; 

public class JsoupEx {
public static void main(String[] args)  {

        BufferedWriter  writer = null;
        try
        {
            Document d = Jsoup.connect("https://www.google.com").get();
            writer = new BufferedWriter( new FileWriter("/home/Desktop/test.txt"));
            writer.write(d.select("body").text());
            writer.close();  // add this line
        }
        catch ( IOException e)
        {
            System.out.println(e);
        }
    }
}