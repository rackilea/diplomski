import com.google.gson.Gson;

public class Main {

    public static void main(String[] args) {
        String response = "{\"json\": {\"errors\": [], \"data\": {\"modhash\": \"dosiom5o6abbbb758729039f04762a05778db4aeeeacd8eb4a\", \"cookie\": \"14756159,2012-08-21T12:05:05,0971bdec35d71af4073cf56ad82fb0ae7c5fe2d1\"}}}";
        GSONClass target = new Gson().fromJson(response, GSONClass.class);
        System.out.println(target);
    }
}