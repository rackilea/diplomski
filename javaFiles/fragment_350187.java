{  
   "productsList":[  
      {  
         "productSubcategory":"Levensverzekering",
         "nameFirstInsured":"Akkerman"
      },
      {  
         "productSubcategory":"Lineair dalend",
         "nameFirstInsured":"Akkerman"
      }
   ]
}



import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class test {

    public static void main(String[] args) throws IOException, InterruptedException {
        JSONParser parser = new JSONParser();
        JSONObject newObj = new JSONObject();
        try {
            Object obj = parser.parse(new FileReader("test.json"));
            JSONObject jsonObject = (JSONObject) obj;
            JSONArray arr = (JSONArray) jsonObject.get("productsList");
            JSONArray newArr = new JSONArray();
            for(int i = 0 ; i < arr.size();i++){
                JSONObject object = (JSONObject) arr.get(i);
                JSONObject a = (JSONObject) object.get("map");
                newArr.add(a);
            }
            newObj.put("productsList", newArr);
            System.out.println(newObj);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}