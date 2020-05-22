protected void onPostExecute(final JSONObject result) {



        try {
            TextView lst2 = (TextView) findViewById(R.id.View2);


            JSONArray cast = result.getJSONObject("body").getJSONArray("und");
            for (int i=0; i<cast.length(); i++) {
                JSONObject actor = cast.getJSONObject(i);
                String name = actor.getString("value");
                lst2.setText(name);
            }




        } catch (Exception e2) {
            Log.v("Error adding article", e2.getMessage());
        }


}