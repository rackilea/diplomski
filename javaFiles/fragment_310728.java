import net.sf.json.JSONException;
import net.sf.json.JSONObject;

public class JSONExample {
    JSONObject json;
    JSONObject objJSON;
    JSONObject objObjJSON;

    public void addtoJSON(){
        json = new JSONObject();
        objJSON= new JSONObject();
        objObjJSON =new JSONObject();

        //adding last tree
        objObjJSON.put(10001, 0);
        objObjJSON.put(10002, 1);

        //adding secondary tree
        objJSON.put("status",1);
        objJSON.put("friends",objObjJSON);

        //added root tree
        objJSON.put(10003,objJSON);

        System.out.println("JSON is " + objJSON);


    }

}