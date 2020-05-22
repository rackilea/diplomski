//Simple JSON
import org.json.simple.JSONObject;

//GSON
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class JSONExamples {

    public static void main(String[] args) {
        String id = "123";
        String title = "Very Important Record";


        //Simple JSON
        JSONObject obj = new JSONObject();
        obj.put("id", id);
        obj.put("title", title);
        System.out.println(obj);


        //GSON
        MyRecord myImportantRecord = new MyRecord(id, title);
        Gson gson = new GsonBuilder().create();
        gson.toJson(myImportantRecord, System.out);

    }

}