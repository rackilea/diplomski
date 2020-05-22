import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFile {
  public static void main(String[]args) throws IOException{

      FileReader in = new FileReader("C:/test.txt");
      BufferedReader br = new BufferedReader(in);
      String line = "";
      String wholeReportText="";
      while ((line = br.readLine()) != null) {
         wholeReportText += line;
      }
      in.close();

           Pattern pattern = Pattern.compile("Movies(.*?)");
           Matcher matcher = pattern.matcher(wholeReportText);
           // check all occurance
           while (matcher.find()) {
                   System.out.println(matcher.group(1));
           }

      Pattern daypat = Pattern.compile("Tuesday (.*?)");
      Matcher daymat = daypat.matcher(wholeReportText);
      // check all occurance
      while (daymat.find()) {
            System.out.println(matcher.group(1));
      }


  }
}