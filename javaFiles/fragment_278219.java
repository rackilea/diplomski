private List<Game> getGames(Context ctx) {
  Gson gson = new Gson();
  SharedPreferences prefs = ctx.getSharedPreferences("SavedGames", Context.MODE_PRIVATE);

  String json = prefs.getString("Games", "");
  if(json.isEmpty()) {
    return new ArrayList<>();
  } else {
    Type type = new TypeToken<List<Game>>(){}.getType();
    return gson.fromJson(json, type);
  }

}