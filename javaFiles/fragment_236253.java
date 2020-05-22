cast = jSon.getJSONArray(TAG_CAST);

  for(int i=0; i < cast.length(); i++){
       JSONObject c = cast.getJSONObject(i);

        String name = c.getString(TAG_NAME);

        display.setText(name);
}