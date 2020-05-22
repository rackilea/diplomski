import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import java.util.Date;

public class GsonApp {

  public static void main(String[] args) {
    GsonApp app = new GsonApp();
    System.out.println(app.createArgsJsonArray("text", 1, 12.2D));
    System.out.println(app.createArgsJsonArray(new Date(), new A(), new String[] {"A", "B"}));
  }

  private Gson gson = new GsonBuilder().create();

  private JsonArray createArgsJsonArray(Object... argVals) {
    JsonArray argsArray = new JsonArray();

    for (Object arg : argVals) {
      argsArray.add(gson.toJsonTree(arg));
    }

    return argsArray;
  }
}

class A {
  private int id = 12;
}