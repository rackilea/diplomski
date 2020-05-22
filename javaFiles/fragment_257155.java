import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class Clazz {
    public static void main(String[] args) throws Exception {

    String singularJson = "{ Token: { TokenId : '123' } }";
    String multipleJson = "{ Token: [{ TokenId : '123' }, { TokenId : '124' }] }";

    JsonElement jsonElementToken = new JsonParser().parse(multipleJson);
    JsonElement jsonCollectionOrSingular = jsonElementToken.getAsJsonObject().get("Token");
    if (jsonCollectionOrSingular.isJsonArray()) {
        System.out.println("It is an collection and not a object");
        JsonArray jsonArray = jsonCollectionOrSingular.getAsJsonArray();
        System.out.println(jsonArray.get(0).getAsJsonObject().get("TokenId"));

    } else {
        System.out.println("It is an object and not a collection");
        JsonObject jsonObject = jsonCollectionOrSingular.getAsJsonObject();
        System.out.println(jsonObject.get("TokenId"));

    }

}