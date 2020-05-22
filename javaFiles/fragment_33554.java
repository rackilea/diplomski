private void processPush(Context context, Intent intent) {
    String msg = "";
    try {
        // Added null check here
        if (intent.getExtras().getString("com.parse.Data") !=null) {
            JSONObject json = new JSONObject(intent.getExtras().getString("com.parse.Data"));
            Iterator itr = json.keys();
            while (itr.hasNext()) {
                String key = (String) itr.next();
                Log.d(TAG, "..." + key + " => " + json.getString(key));
                if (key.equals("customdata")) {
                    msg = json.getString(key);
                }
            }
        }
    } catch (JSONException e) {
        Log.d(TAG, "JSONException: " + e.getMessage());
    }
    generateNotification(context, msg);
}