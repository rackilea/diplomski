try {
    //JSONArray jArray = new JSONArray();
    JSONObject item;
    boolean found = false;
    int length = jArray.length();
    String key = "message";
    String orphan = "message2"; // Let's find where you belong

    for(int index = 0; index < length; index++) {
        item = jArray.getJSONObject(index);
        if(item.getString(key).equals(orphan)) {
            found = true;
            break;
        }
    }

    if(found) {
        // item references the JSONObject that you want
    }
    else {
        // No match found
    }
}
catch(JSONException e) {
    // Try to handle the error gracefully
}