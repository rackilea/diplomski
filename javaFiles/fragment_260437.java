try {
        JSONArray jsonArray = new JSONArray(s);

        for ( int i = 0 ; i < jsonArray.length();i++) {

            Toast.makeText(getApplicationContext(),jsonArray.getString(i),Toast.LENGTH_LONG).show();

        }

} catch (JSONException e) {
     e.printStackTrace();
}