String inputString;
while ((inputString = bufferedReader.readLine()) != null) {
         builder.append(inputString);
       }

        JSONObject jsonRes = new JSONObject(inputString); \\this is the fix 
        JSONArray common = jsonRes.getJSONArray("common");