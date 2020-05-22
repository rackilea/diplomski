import com.google.gson.Gson;
import org.json.JSONObject;

Gson gson = new Gson();

map.put("sss", new JSONObject(gson.toJson(new MyClass(1, "Hello"))));
map.put("aaa", new JSONObject(gson.toJson(new MyClass(2, "blabla"))));

String output = new JSONObject(map).toString();