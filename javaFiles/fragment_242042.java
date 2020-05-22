JSONObject jObj = new JSONObject(result);
        JSONArray jArray = jObj.getJSONArray("posts");

        // Extract data from json and store into ArrayList as class objects
        for (int i = 0; i < jArray.length(); i++) {
            JSONObject json_data = jArray.getJSONObject(i);


            DataFish fishData = new DataFish();
            fishData.status = json_data.getString("status");

            fishData.title = json_data.getString("url");

            fishData.sizeName = json_data.getString("title");


            data.add(fishData);
        }