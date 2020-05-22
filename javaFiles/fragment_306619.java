import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

// parsing code using json.simple  
public class Test2 {

    // path to your file 
    private static String jsonFile = "C:\\bookmarks.json";
    static int count = 0;

    public static void main(String[] args) {

        // a file reader class to access the file using string file path 
        FileReader reader = null;
        try {
            reader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } // access the file
        JSONObject jsonObject = null;

        try {
            jsonObject = (JSONObject) new JSONParser().parse(reader);
        } catch (IOException | ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        String checksum = (String) jsonObject.get("checksum");

        JSONObject root = (JSONObject) jsonObject.get("roots");

        Set<String> set = root.keySet();
        JSONArray childrens = null;
        JSONObject obj = null;
        for (String string : set) {
            try {
                obj = (JSONObject) root.get(string);
            } catch (ClassCastException e) {

            }
            if (obj.containsKey("children")) {
                try {
                    childrens = (JSONArray) obj.get("children");
                    printUrls(childrens);
                } catch (Exception e) {

                }
            }
        }
        // display , how many urls we have found  
        System.out.println("count is " + count);
    }

    public static void printUrls(JSONArray childrens) {
        JSONObject temp = null;
        for (int i = 0; i < childrens.size(); i++) {
            // get object using index from childrens array
            temp = (JSONObject) childrens.get(i);
            if (temp.containsKey("children")) {
                printUrls((JSONArray) temp.get("children"));
            }
            // get url
            String url = (String) temp.get("url");
            if (url != null) {
                System.out.println(url);
                count++;
            }
        }

    }
}