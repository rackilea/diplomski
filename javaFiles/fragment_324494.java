public static void main(String args[]){

    String input = "{"
            + "\"entry\": \"132456\","
            + "\"product\": {\"item\": \"123456\","
            + "\"prompts\":[{\"promptId\": \"1\","
            + "\"promptNumber\": \"109\","
            + "\"promptType\": 4,"
            + "\"promptTypeDesc\": \"desc1\","
            + "\"validations\":[{\"minLen\": 10,"
            + "\"maxLen\": 10"
            + ",\"required\": true}]}]}}";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Info item = gson.fromJson(input, Info.class);

    String jsonOutput = gson.toJson(item);
    System.out.println(jsonOutput);
}