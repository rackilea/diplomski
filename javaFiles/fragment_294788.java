import java.util.Map;

import net.sf.json.JSONObject;

public class Foo
{
  static String json = "{\"one\":\"won\",\"two\":2,\"three\":false}";

  public static void main(String[] args)
  {
    JSONObject jsonObject = JSONObject.fromObject(json);
    Map map = jsonObject;
    System.out.println(map);
  }
}