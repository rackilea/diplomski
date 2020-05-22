import org.json.JSONArray;
import org.json.JSONObject;

public class Foo
{
  public static void main(String[] args) throws Exception
  {
    String jsonInput = "{\"JObjects\":{\"JArray1\":[{\"A\":\"a\",\"B\":\"b\",\"C\":\"c\"},{\"A\":\"a1\",\"B\":\"b2\",\"C\":\"c3\",\"D\":\"d4\",\"E\":\"e5\"},{\"A\":\"aa\",\"B\":\"bb\",\"C\":\"cc\",\"D\":\"dd\"}]}}";

    // "I want to iterate though the objects in the array..."
    JSONObject outerObject = new JSONObject(jsonInput);
    JSONObject innerObject = outerObject.getJSONObject("JObjects");
    JSONArray jsonArray = innerObject.getJSONArray("JArray1");
    for (int i = 0, size = jsonArray.length(); i < size; i++)
    {
      JSONObject objectInArray = jsonArray.getJSONObject(i);

      // "...and get thier component and thier value."
      String[] elementNames = JSONObject.getNames(objectInArray);
      System.out.printf("%d ELEMENTS IN CURRENT OBJECT:\n", elementNames.length);
      for (String elementName : elementNames)
      {
        String value = objectInArray.getString(elementName);
        System.out.printf("name=%s, value=%s\n", elementName, value);
      }
      System.out.println();
    }
  }
}
/*
OUTPUT:
3 ELEMENTS IN CURRENT OBJECT:
name=A, value=a
name=B, value=b
name=C, value=c

5 ELEMENTS IN CURRENT OBJECT:
name=D, value=d4
name=E, value=e5
name=A, value=a1
name=B, value=b2
name=C, value=c3

4 ELEMENTS IN CURRENT OBJECT:
name=D, value=dd
name=A, value=aa
name=B, value=bb
name=C, value=cc
*/