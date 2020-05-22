public class Main {

    public static void main(String[] args) {
        JsonParser parser = new JsonParser();
        JsonObject json  = parser.parse("{\"id\":\"2\",\"type\":\"book\",\"base_data\":{\"result\":[{\"retailer\":\"Amazon\",\"price\":\"$50\"},{\"retailer\":\"Target\",\"price\":\"$60\"}],\"pager\":{\"current_page\":\"5\",\"link\":\"www.somesite.com\"}}}").getAsJsonObject();

        Gson gson = new Gson();
        Model model = gson.fromJson(json, Model.class);

    }
}

class Model {
    String id;
    String type;
    BaseData base_data;
}

class BaseData {
    Map<String, String> pager;
    List<Map<String,String>> result;
}

class Result {
    String retailer;
    String price;
}