import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Iterator;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


/**
 * 
 */
public class ParseWithJsoup{


    public static void main(String[] args) {

        URL url;

        try {

            url = new URL("http://www.cbsa-asfc.gc.ca/bwt-taf/menu-eng.html");
            URLConnection conn = url.openConnection();

            BufferedReader buffRead = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuffer buffer = new StringBuffer("");

            String inputLine = "";

            // Append the site in a buffer
            while (inputLine != null){
                inputLine = buffRead.readLine();
                buffer.append(inputLine);
            }

            Document doc = Jsoup.parse(buffer.toString());

            // Parse the table
            Element table = doc.select("table[class=bwt]").first();

            //Office elements iterator
            Iterator<Element> officeElements = table.select("td[headers=Office]").iterator();

            //Commercial Flow iterator
            Iterator<Element> comElements = table.select("td[headers=Com ComCanada]").iterator();

            //Travellers Flow iterator
            Iterator<Element> travElements = table.select("td[headers=Trav TravCanada]").iterator();


            // Iterate all elements through first element row for all columns
            while(officeElements.hasNext()){            
                System.out.println("Office: " + officeElements.next().text());
                System.out.println("Commercial Flow: " + comElements.next().text());
                System.out.println("Travellers Flow: " + travElements.next().text());
            }

        }
        catch (Exception e){
            System.out.println("Exc:"+e.getMessage());
        }
    }


}