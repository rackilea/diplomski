public static void add(JsonObject body) {  
    Gson gson = new Gson();
    String json = gson.toJson(body, Bookmark.class);
    Bookmark bookmark = gson.fromJson(json, Bookmark.class);
    bookmark.save(); 
}