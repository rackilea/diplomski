while ((line = reader.readLine()) != null) {
            buffer.append(line+"\n");
        }

        Log.d("Response: ", "> " + line);
        try {
             JSONObject  jsonRootObject = new JSONObject(line);

             JSONArray jsonArray = jsonRootObject.optJSONArray("results");
             for(int i=0; i < jsonArray.length(); i++){
             JSONObject jsonObject = jsonArray.getJSONObject(i);
             data = jsonObject.getString("formatted_address")

          }

          } catch (JSONException e) {e.printStackTrace();}
         return data;