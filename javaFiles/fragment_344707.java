JSONObject jsonObject = new JSONObject(jsonResponse);//put your json response
        JSONArray jsonArray = null;
        try {
            String station = jsonObject.getString("Station");
            jsonArray = jsonObject.getJSONArray("debit");
            for(int i=0;i<jsonArray.length();i++)
            {

                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                int niveauEau = jsonObject1.getInt("niveauEau");
                int debit = jsonObject1.getInt("debit");
                String isStation = jsonObject1.getString("idStation");
                boolean etatPerimetrique = jsonObject1.getBoolean("etatPerimetrique");
                int chargeBatterie = jsonObject1.getInt("chargeBatterie");

                JSONObject jsonObject2 = jsonObject1.getJSONObject("dateReleve");

                String date = jsonObject2.getString("date");
                int timezone_type = jsonObject2.getInt("timezone_type");
                String timezone = jsonObject2.getString("timezone");

            }

        } catch (JSONException e) {
            e.printStackTrace();
        }