public static final MY_LIST = "my_list";

List<String> myList = new ArrayList<String>();
SharedPreferences.Editor editor = prefs.edit();
editor.putString(MY_LIST, new Gson().toJson(myList));
editor.commit();