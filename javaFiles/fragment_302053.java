ArrayList<MyClass> array = new ArrayList<>();

SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
SharedPreferences.Editor editor = prefs.edit();

// Put
Gson gson = new Gson();
String json = gson.toJson(array);
editor.putString("preference_key", json);
editor.commit(); //every change in editor object is commited.
// Get
json = prefs.getString("preference_key", null);
java.lang.reflect.Type type = new TypeToken<ArrayList<MyClass>>(){}.getType();
array = gson.fromJson(json, type);