package miCMS;
{***}
import org.json.JSONArray;
import org.json.JSONObject;
{***}
JSONArray eventArr = new JSONArray();
{***}
public class MiPlayer{
{***}

public void addEvent(int id, int time, String file, String comment) {
    try {
        JSONObject event = new JSONObject();
        event.put("Id", id);
        event.put("Time", time);
        event.put("File", file);
        event.put("Comment", comment);
        eventArr.put(event);
    }catch ( Exception e ) {e.printStackTrace();}
}