try 
{
     JSONArray jsonArray = new JSONArray("Your jsonString");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONArray jsonArray1 = jsonArray.getJSONArray(i);

            for (int j = 0; j < jsonArray1.length(); j++) {

                Log.i(" ROW " + i + " Col " + j, ": " + jsonArray1.get(j));
            }

        }
}
catch (JSONException e) 
{
    e.printStackTrace();
}