response = json.getJSONArray(TAG_RESPONSE);

// from your example, num will be 50036:
num = response.getInt(0);

for (int i = 1; i < response.length(); i++){
    JSONObject c = response.getJSONObject(i);