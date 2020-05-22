import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadJsonFile
{
    public static void main(String[] args)
    {        
        readJsonFile();
    }

    public static void readJsonFile() {

        BufferedReader br = null;
        JSONParser parser = new JSONParser();

        try {

            String sCurrentLine;

            br = new BufferedReader(new FileReader("D:\\example.json"));

            while ((sCurrentLine = br.readLine()) != null) {
                System.out.println("Record:\t" + sCurrentLine);

                Object obj;
                try {
                    obj = parser.parse(sCurrentLine);
                    JSONObject jsonObject = (JSONObject) obj;

                    String rel = (String) jsonObject.get("rel");
                    System.out.println(rel);

                    String start = (String) jsonObject.get("start");
                    System.out.println(start);

                    String end = (String) jsonObject.get("end");
                    System.out.println(end);

                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null)br.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}