JSONArray jsonArray = null;
        jsonArray = new JSONArray(ANSWER);
        for (int i = 0; i < jsonArray.length(); ) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            //jsonObject = jsonArray.getJSONObject(i); **remove this line thne check remove this line thne check**

            String CASH = (String) jsonObject.getString("bal");
            String USER_VALUE = (String) jsonObject.getString("valve");
            String INVEST = (String) jsonObject.getString("invested");
            String PROFIT = (String) jsonObject.getString("aProfit");
            String COST_P = (String) jsonObject.getString("cost");
            String COUNT = (String) jsonObject.getString("count");


        }
    }catch (Exception e){
    }