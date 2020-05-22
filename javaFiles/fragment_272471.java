JSONArray artistsArr = myObject.getJSONArray("files_informations");
for (int i = 0; i < artistsArr.size(); i++) {
     // first case
     Log.d(TAG, artistsArr.get(i).getString("value"));
     // Second case
     Log.d(TAG, artistsArr.getString(i));
}