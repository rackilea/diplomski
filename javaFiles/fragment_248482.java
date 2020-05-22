import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class Test {

    public static void main(String[] args) {
        Gson gson = new Gson();

        String line = "{\"id\":\"iprod\",\"name\":\"soup\",\"categoryId\":\"categoryId123\",\"categoryName\":\"soup\",\"imageUrl\":\"c/image\",\"price\":5.0,\"weight\":123.0,\"ingredients\":[\"chicken\",\"rice\"],\"nutrition\":{\"energy\":{\"kilojoules\":123,\"kilocalories\":123},\"fat\":123,\"carbohydrate\":123,\"protein\":123},\"currency\":\"123\"}\n";

        System.out.println(line);
        JsonObject responseObject = gson.fromJson(line, JsonObject.class);
        System.out.println(responseObject.keySet());

    }

}