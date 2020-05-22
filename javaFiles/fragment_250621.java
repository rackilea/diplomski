HttpURLConnection conn = null;
try {
    URL url = new URL(/* url */);
    conn = (HttpURLConnection)url.openConnection(); //this can give 401
    JsonReader reader = new JsonReader(new InputStreamReader(conn.getInputStream()));

    JsonObject response = gson.fromJson(reader, JsonObject.class);
} catch(IOException ex) {
    JsonReader reader = new JsonReader(new InputStreamReader(conn.getErrorStream()));
    JsonObject response = gson.fromJson(reader, JsonObject.class);
}