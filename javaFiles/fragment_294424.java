import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.json.JSONException;
import org.json.JSONObject;

import com.fasterxml.jackson.databind.ObjectMapper;


public class Test {

    public static void main(String[] args) throws JSONException, IOException 
    {
        ObjectMapper mapper = new ObjectMapper();
        String key = "key1"; //whatever

        JSONObject jo = new JSONObject("{key1:\"val1\", key2:\"val2\"}");
        //Read from file
        JSONObject root = mapper.readValue(new File("json_file"), JSONObject.class);

        String val_newer = jo.getString(key);
        String val_older = root.getString(key);

        //Compare values
        if(!val_newer.equals(val_older))
        {
          //Update value in object
           root.put(key,val_newer);

           //Write into the file
            try (FileWriter file = new FileWriter("json_file")) 
            {
                file.write(root.toString());
                System.out.println("Successfully updated json object to file...!!");
            }
        }
    }
}