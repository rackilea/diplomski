import java.io.FileReader;
import java.lang.reflect.Type;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    Gson gson = new Gson();
    Type mapOfStringObjectType = new TypeToken<Map<String, String>>() {}.getType();
    Map<String, String> map = gson.fromJson(new FileReader("input.json"), mapOfStringObjectType);
    System.out.println(map);
  }
}