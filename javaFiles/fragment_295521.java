package stackoverflow;

 import javax.swing.JOptionPane;
 import java.io.IOException;
 import java.util.logging.*;
 import org.jsoup.*;
 import org.jsoup.nodes.*;
 import org.jsoup.select.*;

 public class SimpleDialogBox 
 {
     public static void main(String[] args) 
     {
         // TODO code application logic here
        try 
        {
            String url = "http://bmreports.com/bsp/additional/soapfunctions.php?element=SYSPRICE&dT=NRT";
            Document doc = Jsoup.connect(url).get();
            Elements SSPparagraphs;
            SSPparagraphs = doc.select("SSP");  
            //paragraphs = doc.select("SBP");

            String[] numbers = SSPparagraphs.text().toString().split(" ");
            String formattedText = new String("");
            for (int x = 0; x < numbers.length; x++)
            {
                formattedText += numbers[x] + "\n";
            }

            System.out.println(formattedText);

            //(Element paragraphs : SSPparagraphs)
            JOptionPane.showMessageDialog(
                null, formattedText, "Cashout Prices", JOptionPane.PLAIN_MESSAGE);
            System.exit(0);
        }   
        catch (IOException ex) 
        {
            Logger.getLogger(SimpleDialogBox.class.getName())
            .log(Level.SEVERE, null, ex);
        }
      }
 }