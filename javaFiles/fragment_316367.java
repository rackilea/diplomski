package stackoverflow.questions.q19124387;

import java.lang.reflect.Type;
import java.util.*;



import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

public class Q19124387 {

   public static class User {
      private String name;
      private String age;
      private String gender;
      @Override
      public String toString() {
         return "User [name=" + name + ", age=" + age + ", gender=" + gender + "]";
      }



   }

   public static class Result {
      private List<User> users = new ArrayList<User>();

   }

   public static class Response {
      private Result result;

   }

   public static class Data {
      private Response response;

   }

   public static class CustomDeserializer implements JsonDeserializer<Result> {

      public Result deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

         Result r = null;

         JsonElement usersField = json.getAsJsonObject().get("users");
         if (usersField.isJsonNull() || usersField.isJsonPrimitive())
            ; // if is null or is a primitive type will return an empty result
         else if (usersField.isJsonObject()) {
            r = new Result();
            r.users.add((User) context.deserialize(usersField, User.class));

         } else if (usersField.isJsonArray()) {
            Type listOfUserType = new TypeToken<List<User>>() {}.getType();
            r = new Result();

            r.users.addAll((Collection<? extends User>) context.deserialize(usersField, listOfUserType));

         }
         return r;

      }

   }

   /**
    * @param args
    */
   public static void main(String[] args) {
      String json1 = " {\"response\": {  \"result\": { \"users\": [{ name: \"ABC\",  age: \"20\", gender: \"F\"  },  { name: \"cbd\",  age: \"23\", gender: \"M\"  }] }  }  }";

      String json2 = "{\"response\": { \"result\": {\"users\": { name: \"ABC\", age: \"20\",gender: \"F\" } } } }  ";

      Gson g = new Gson();
      try {
         Data d1 = g.fromJson(json1, Data.class);
         System.out.println("Parsed json1, list of users");
      } catch (Exception e) {
         System.out.println("Cannot parse json1, list of users");
      }
      try {
         Data d2 = g.fromJson(json2, Data.class);
         System.out.println("Parsed json2, single user");
      } catch (Exception e) {
         System.out.println("Cannot parse json2, single user");
      }

      GsonBuilder gb = new GsonBuilder();
      gb.registerTypeAdapter(Result.class, new CustomDeserializer());
      Gson g2 = gb.create();

      Data d1 = g2.fromJson(json1, Data.class);
      Data d2 = g2.fromJson(json2, Data.class);

      System.out.println("Second user of json1 is " + d1.response.result.users.get(1));
      System.out.println("First user of json2 is " + d2.response.result.users.get(0));

   }

}