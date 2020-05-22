import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Test {

    public static void main(String[] args) 
    {
        String sCurrentLine = null, CN = null;
        try (BufferedReader br = new BufferedReader(new FileReader("resultofbatch.txt")))
        {

            while ((sCurrentLine = br.readLine()) != null) 
            {
                if(sCurrentLine.matches(".*CN=([^,]*).*"))
                {

                    Pattern p = Pattern.compile(".*CN=([^,]*),");
                    Matcher m = p.matcher(sCurrentLine);
                    m.find();
                    CN = m.group(1);
                }

            }

            if(CN != null)
            {
                //TODO do somethign with CN
                System.out.println(CN);
            }
            else
            {
                System.out.println("CN not found");
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}