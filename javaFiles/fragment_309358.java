public static void main(String[] args) {
    // The JSON from your post
    String json = "{\"header\":[{\"title\":{\"attempts\":3,\"required\":true}},{\"on\":{\"next\":\"abcd\",\"event\":\"continue\"}},{\"on\":{\"next\":\"\",\"event\":\"break\"}}]}";

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    Response response = gson.fromJson(json, Response.class);

    System.out.println(response.header.get(0).title.attempts); // 3
    System.out.println(response.header.get(1).on.next); // abcd
    System.out.println(gson.toJson(response)); // Produces the exact same JSON as the original
}