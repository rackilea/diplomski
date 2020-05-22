import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by ebi on 7/3/17.
 */
public class Main {
    public static void main(String[] args) throws JSONException {

        String str = "user.phone.num : 00113";
        String json_str = str_to_json(str);
        JSONObject jsonObject = new JSONObject(json_str);
        System.out.println(jsonObject);
    }

    public static String str_to_json(String jsonByDot){
        int valOffset = jsonByDot.indexOf(":");
        String keys = jsonByDot.substring(0,valOffset).trim();
        String val = jsonByDot.substring(valOffset+1).trim();

        String keysArr[] = keys.split("\\.");
        String output = "";
        for(String key:keysArr){
            output+="{"+key+":";
        }
        output+=val;
        for (int i = 0 ;i<keysArr.length;i++){
            output+="}";
        }

        return  output;
    }
}