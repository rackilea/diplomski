SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(context);
Editor editor = sharedPrefs.edit();
Gson gson = new Gson();
String json = gson.toJson(your_array_list);
editor.putString(TAG, json);
editor.commit();