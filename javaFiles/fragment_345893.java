try {
        JSONArray jsonArray=new JSONArray(response);
        for (int i=0;i<jsonArray.length();i++)
        {
            JSONObject jsonObject=jsonArray.getJSONObject(i);

            String X=jsonObject.getString("X");
            String Y=jsonObject.getString("Y");
            String Count=jsonObject.getString("Count");

            JSONArray jsonArraydates=jsonObject.getJSONArray("Dates");

            for (int j=0;j<jsonArraydates.length();j++)
            {
                JSONObject jsonObjectDates=jsonArraydates.getJSONObject(j);


                String Date=jsonObjectDates.getString("Date");
                String Time=jsonObjectDates.getString("Time");


            }

        }
    } catch (JSONException e) {
        e.printStackTrace();
    }