for (int i = 0; i < jsonArray.length(); i++) {
    // get object i
    JSONObject jsonObject = jsonArray.getJSONObject(i);
    // check if object has mutualFund key
    if (jsonObject.has("mutualFund")) {
        // get mutualFund object and do something with it
        JSONObject mutualFund = jsonObject.getJSONObject("mutualFund");
        // do something with mutualFund object (you can get values for fundCode and fundName keys, etc)
    }
}