import com.google.gson.Gson;

public class GsonExample {
    public static void main(String[] args) {
        String json = "{\"balance\":1000,\"lastliability\":2000,\"profitarray\":[[1,2,3],[67,88,99]],\"previous\":[99,88]}";

        Response response = new Gson().fromJson(json, Response.class);
        System.out.println(response.profitarray);
    }
}