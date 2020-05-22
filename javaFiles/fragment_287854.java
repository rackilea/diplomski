JSONArray jsonArray = response.getJSONArray("suggestedDomains");
    for(int i = 0; i < jsonArray.length(); i++) {
        JSONObject suggestedDomains = jsonArray.getJSONObject(i);
        String domain = suggestedDomains.getString("domain");
        String listPrice = suggestedDomains.getString("listPrice");
        mTextViewResult.append(domain + ", " + listPrice + "\n\n"  );
}