import java.util.Vector;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;

public static void main(String[] args) {

    Vector<Vector> v = new Vector();

    Vector v1 = new Vector(); 
    v1.add("1"); 
    v1.add("001555"); 
    v1.add("LK"); 
    v1.add(24); 
    v1.add("KO"); 

    Vector v2 = new Vector(); 
    v2.add("0005"); 
    v2.add("125"); 
    v2.add("SL"); 
    v2.add("85"); 
    v2.add("FOO"); 

    v.add(v1);
    v.add(v2);

    JSONArray ja = new JSONArray();

    Vector tmp;

    for(int j=0; j<v.size(); j++)
    {
        tmp = v.get(j);

        JSONObject obj = new JSONObject();
        for (int i=0; i<tmp.size(); i++)
        {
            try {
                if(i==0)
                    obj.put("id", tmp.get(i));
                else
                    obj.put("String"+i, tmp.get(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        ja.put(obj);
    }   

    System.out.println(ja.toString());

}