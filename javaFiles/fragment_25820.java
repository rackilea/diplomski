class MyAsyncTask extends AsyncTask<Void, Void, JSONArray>{

    @Override
    protected JSONArray doInBackground(Void... params) {
        JSONParser jParser = new JSONParser();
        String temp = "http://sandbox.kriswelsh.com/hygieneapi/hygiene.php?op=nearest&lat=" + latitude + "&long=" + longitude;
        JSONArray json = jParser.getJSONFromUrl(temp);
        return json;
    }

    @Override
    protected void onPostExecute(JSONArray json) {
        TableLayout tl = (TableLayout) findViewById(R.id.table);
        for (int i = 0; i < 10; i++) {

            try {
                JSONObject c = json.getJSONObject(i);
                String vid = c.getString(id);
                String vbn = c.getString(BusinessName);
                String va1 = c.getString(Add1);
                String va2 = c.getString(Add2);
                String va3 = c.getString(Add3);
                String vpost = c.getString(Post);
                String vlong = c.getString(longitudej);
                String vrate = c.getString(RatingDate);
                String vratestar = c.getString(Rating);
                String vlat = c.getString(latitudej);

                if (vratestar.contentEquals("-1")) {
                    vratestar = "Exempt";
                }

                TableRow tableRow = new TableRow(context);
                //configuring row, setting layout params
                tl.addView(tableRow);

            } catch (JSONException ex){
                //error handling
            }
        }
    }
}