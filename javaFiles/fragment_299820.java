private static final CATEGORIES_KEY = "CATEGORIES";
public void saveCategories(List<DataModel> list){
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());
    SharedPreferences.Editor editor = prefs.edit();
    Gson gson = new Gson();
    String json = gson.toJson(list);
    editor.putString(CATEGORIES_KEY, json);
    editor.apply(); 
}

public List<DataModel> getCategories(){
    SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this.getApplicationContext());

    List<Model> models;
    Gson gson = new Gson();
    String json = prefs.getString(CATEGORIES_KEY, null);
    Type type = new TypeToken<List<DataModel>>() {}.getType();

   try {
     models = gson.fromJson(json, type);
   } catch (IllegalStateException | JsonSyntaxException exception) {
     // You need to catch the error here
     Log.d("CONVERT", exception);
   }

   return models;
}