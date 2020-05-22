import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

 public class ABC {

  public class User {

    public String name;
    public String id;
    public Address[] address;
  }

  public class Address {

    public String street;
    public String city;
    public String state;

  }


  public static ExclusionStrategy createStrategy(List<String> fields) {
    return new ExclusionStrategy() {
      public boolean shouldSkipField(FieldAttributes fieldAttributes) {
        if (fields.stream().anyMatch(e -> e.equals(fieldAttributes.getName()))) {
          return false;
        }
        return true;
      }

      public boolean shouldSkipClass(Class aClass) {
        return false;
      }
    };
  }


  public String fetchUsers(List<User> users, List<String> fields) {
    GsonBuilder builder = new GsonBuilder();
    builder.setExclusionStrategies(createStrategy(fields));
    Gson gson = builder.create();
    return gson.toJson(users);
  }

  public static void main(String[] args) {
    ABC x = new ABC();

    Address add = x.new Address();
    add.city = "city";
    add.state = "state";
    add.street = "street";

    Address[] array = new Address[1];
    array[0] = add;

    User user = x.new User();
    user.address = array;
    user.id = "id";
    user.name = "name";

    List<User> users = new ArrayList<>();
    users.add(user);

    List<String> fields = Arrays.asList("name", "address", "state");
    String json = x.fetchUsers(users, fields);

    System.out.println(json);

  }


}