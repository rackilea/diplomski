package json2;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class JSON {

    public static void main(String a[]){

        String FILEPATH = "D:\\User\\Documents\\Eclipse\\JSON2\\simplemapping.txt"; 

        Map<String,Object> resultMap = new HashMap<String,Object>();
        ObjectMapper mapperObj = new ObjectMapper();

        System.out.println("Input Json: "+FILEPATH);
        try {
            resultMap = mapperObj.readValue(new File(FILEPATH),
                            new TypeReference<HashMap<String,Object>>(){});
            System.out.println("Output Map: "+resultMap);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}