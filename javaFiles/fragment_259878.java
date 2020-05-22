JSONObject obj = null;
        try {
            obj = new JSONObject(json);

        JSONArray arr = obj.getJSONArray("Computer");

        for (int i = 0; i < arr.length(); i++)
        {
            JSONObject obj_computers = arr.getJSONObject(i);
            JSONArray sub1 = obj_computers.getJSONArray("sub1");

            for (int j = 0; j < sub1 .length(); j++)
            {
                JSONObject sub1_data = sub1.getJSONObject(j);
                Log.i("test" ,sub1_data.toString());
            }
        }
        } catch (JSONException e) {
            e.printStackTrace();
        }