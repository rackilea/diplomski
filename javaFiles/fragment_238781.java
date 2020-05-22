SharedPreferences sp = this.getSharedPreferences(TEMP_KEY, MODE_PRIVATE);
Gson gson = new Gson();

String objectJson = gson.toJson(object, Object.class);
String activityJson = "FirstActivity";

SharedPreferences.Editor editor = sp.edit();
editor.putString(CONTINUE_KEY, objectJson);
editor.putString(ACTIVITY_KEY, activityJson);
editor.apply();