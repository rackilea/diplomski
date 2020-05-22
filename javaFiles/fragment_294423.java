import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;


public class Test {

    public static void main(String[] args) {
        FileReader reader;
        try {
            reader = new FileReader("/test.json");
            JsonParser jsonParser =  new JsonParser();
            JsonArray array = (JsonArray) jsonParser.parse(reader);
            searchJsonElemnet(array);
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        }
    }

    private static void searchJsonElemnet(JsonArray jsonArray){
        String[][] matrix = new String[2][4];
        int i =0;
        int j = 0;
        for (JsonElement jsonElement : jsonArray) {
             for (Map.Entry<String, JsonElement> entry : jsonElement.getAsJsonObject().entrySet()) {
                 matrix[i][j] = entry.getValue().toString();
                 j++;
            }
            i++;
            j = 0;
        }
        for (String[] row : matrix)
        {
            for (String value : row)
            {
                System.out.println(value);
            }
        }
    }

}