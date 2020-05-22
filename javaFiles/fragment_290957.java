// output: 
//   [MyObject: element1=value1, element2=value2, element3=value3]
//   [MyObject: element1=value1, element2=value2, element3=null]
//   Exception in thread "main" com.google.gson.JsonParseException: Required Field Not Found: element2

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

public class Foo
{
  static String jsonInput1 = "{\"element1\":\"value1\",\"element2\":\"value2\",\"element3\":\"value3\"}";
  static String jsonInput2 = "{\"element1\":\"value1\",\"element2\":\"value2\"}";
  static String jsonInput3 = "{\"element1\":\"value1\",\"element3\":\"value3\"}";

  public static void main(String[] args)
  {
    GsonBuilder gsonBuilder = new GsonBuilder();
    MyDeserializer deserializer = new MyDeserializer();
    deserializer.registerRequiredField("element2");
    gsonBuilder.registerTypeAdapter(MyObject.class, deserializer);
    Gson gson = gsonBuilder.create();
    MyObject object1 = gson.fromJson(jsonInput1, MyObject.class);
    System.out.println(object1);
    MyObject object2 = gson.fromJson(jsonInput2, MyObject.class);
    System.out.println(object2);
    MyObject object3 = gson.fromJson(jsonInput3, MyObject.class);
    System.out.println(object3);
  }
}

class MyObject
{
  String element1;
  String element2;
  String element3;

  @Override
  public String toString()
  {
    return String.format(
        "[MyObject: element1=%s, element2=%s, element3=%s]",
        element1, element2, element3);
  }
}

class MyDeserializer implements JsonDeserializer<MyObject>
{
  List<String> requiredFields = new ArrayList<String>();

  void registerRequiredField(String fieldName)
  {
    requiredFields.add(fieldName);
  }

  @Override
  public MyObject deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException
  {
    JsonObject jsonObject = (JsonObject) json;
    for (String fieldName : requiredFields)
    {
      if (jsonObject.get(fieldName) == null)
      {
        throw new JsonParseException("Required Field Not Found: " + fieldName);
      }
    }
    return new Gson().fromJson(json, MyObject.class);
  }
}