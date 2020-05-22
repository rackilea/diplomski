import java.lang.reflect.Type;
import com.google.gson.reflect.TypeToken;

...

Type listType = new TypeToken<ArrayList<YourClass>>(){}.getType();
List<YourClass> yourClassList = new Gson().fromJson(jsonArray, listType);