private void saveGames(Lis<Game> games) {
   Gson gson = new Gson();
   String json = gson.toJson(games);
   SharedPreferences prefs = ctx.getSharedPreferences("SavedGames", Context.MODE_PRIVATE);
   SharedPreferences.Editor editor = prefs.edit();
   editor.putString("Games", json);
   editor.commit();
}