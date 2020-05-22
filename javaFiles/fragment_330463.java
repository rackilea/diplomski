protected void onPostExecute(JSONObject s) {          
        super.onPostExecute(s);

        dialog.dismiss();
        Log.e("Test JSON","JSON s returns: " + s);
        try {
            directory = s.getJSONArray("Categories");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        for(int i = 0; i< directory.length(); i++){
            String str_id = directory.optString(i, "id");
            String str_name = directory.optString(i, "name");
            displayCatList(str_id, str_name);

            Log.e("Test directory","Directory returns: " + json);
        }
        listOfServices = DisplayServiceActivity.this.getListView(); //get builtin listView
        ListAdapter adapter = new SimpleAdapter(DisplayServiceActivity.this,
            directoryList, 
            R.layout.list_item, 
            new String[] { TAG_ID,TAG_NAME }, 
            new int[] { android.R.id.text1,android.R.id.text2 });

        setListAdapter(adapter);
    }