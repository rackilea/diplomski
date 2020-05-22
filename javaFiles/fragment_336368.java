import java.io.IOException;  
import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.nodes.Element;

public class WebScraping{  
    public static void main( String[] args ) throws IOException{  
            String html = "<i class='fa fa-star'></i> <a href='#taskruns' data-toggle='tab'>396900 runs submitted</a>";


            Document doc = Jsoup.parse(html); //First you have to parse html 
            Element link = doc.select("a").first(); //Then find the css selector from which you want to extract data

            String linkText = link.text(); //Then extract the text from selector

            System.out.println(linkText);
    }  
}