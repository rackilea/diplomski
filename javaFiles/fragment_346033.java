import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GsonExample {
  private static final Logger logger = Logger.getLogger(GsonExample.class.getName());
  private static final String JSON = 
    "{"
      + "\"2002\": ["
        + "{"
          + "\"d\": \"description\","
          + "\"t\": \"title\""
        + "}"
      + "],"
      + "\"2003\": ["
        + "{"
          + "\"d\": \"description\","
          + "\"t\": \"title\""
        + "}"
      + "]"
    + "}";

  public static void main(String[] args) {
    GsonExample e = new GsonExample();
    e.run();
  }

  private void run() {
    GsonBuilder builder = new GsonBuilder();
    Type type = new TypeToken<List<Program>>(){}.getType();
    builder.registerTypeAdapter(type, new ProgramsDeserializer());
    Gson gson = builder.create();
    List<Program> programs = gson.fromJson(JSON, type);
    logger.log(Level.INFO, "{0}", programs);
  }
}