import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;

public class App
{
  public static void main(String[] args)
  {
    Barn[] barns = {new Barn(), new Barn()};
    barns[0].type = "horse";
    barns[0].animal = new Horse();
    barns[1].type = "cow";
    barns[1].animal = new Cow();

    String json = new Gson().toJson(barns);
    // [{"type":"horse","animal":{}},{"type":"cow","animal":{}}]

    BarnDeserializer deserializer = new BarnDeserializer("type");
    deserializer.registerBarnType("horse", Horse.class);
    deserializer.registerBarnType("cow", Cow.class);
    Gson gson = new GsonBuilder().registerTypeAdapter(Barn.class, deserializer).create();

    List<Barn> barns2= gson.fromJson(json, new TypeToken<List<Barn>>(){}.getType());
    for (Barn barn : barns2)
    {
      System.out.println(barn.animal.getClass());
    }
  }
}

class BarnDeserializer implements JsonDeserializer<Barn>
{
  String barnTypeElementName;
  Gson gson;
  Map<String, Class<? extends Animal>> barnTypeRegistry;

  BarnDeserializer(String barnTypeElementName)
  {
    this.barnTypeElementName = barnTypeElementName;
    gson = new Gson();
    barnTypeRegistry = new HashMap<>(); // Java 7 required for this syntax.
  }

  void registerBarnType(String barnTypeName, Class<? extends Animal> animalType)
  {
    barnTypeRegistry.put(barnTypeName, animalType);
  }

  @Override
  public Barn deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) 
      throws JsonParseException
  {
    JsonObject barnObject = json.getAsJsonObject();
    JsonElement animalTypeElement = barnObject.get(barnTypeElementName);
    Barn barn = new Barn();
    barn.type = animalTypeElement.getAsString(); 
    Class<? extends Animal> animalType = barnTypeRegistry.get(barn.type);
    barn.animal = gson.fromJson(barnObject.get("animal"), animalType);
    return barn;
  }
}

class Barn {String type; Animal animal;}
class Animal {}
class Horse extends Animal {}
class Cow extends Animal {}