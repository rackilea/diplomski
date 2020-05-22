import java.lang.reflect.Type;
import java.util.Map;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;

public class JsonTest {
  private static final String JSON = "{" +
    "\"309\":{ \"productId\":309,  \"name\":\"Heat Gear Polo\"}," +
    "\"315\":{ \"productId\":310,  \"name\":\"Nike\"},"+
    "\"410\":{ \"productId\":311,  \"name\":\"Armani\"}"+
  "}";

  public static void main(String... args) {
    Gson g = new Gson();
    Type type = new TypeToken<Map<Integer, Product>>(){}.getType();
    Map<Integer, Product> map = g.fromJson(JSON, type);

    System.out.println(map);
  }

  public static class Product
  {
     private int productId;
     private String name;

    @Override
    public String toString() {
      return String.format("Product [productId=%s, name=%s]", productId, name);
    }     
  }
}