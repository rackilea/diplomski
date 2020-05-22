public void openString(){


SharedPreferences sharedPrefs = PreferenceManager.getDefaultSharedPreferences(getContext());
Gson gson = new Gson();
String json = sharedPrefs.getString("kEy", null);

   Type type = new TypeToken<ArrayList<EdtText>>() {
    }.getType();
    ArrayList<EdtText> arrayList = gson.fromJson(json, type);


    if (arrayList != null) {
        editTexts = arrayList;
    }