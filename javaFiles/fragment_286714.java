if (object != null) {

    try {

    JSONObject jsonObject = object.getInnerJSONObject().getJSONObject("summary");
    int notificationsUnread = jsonObject.getInt("unseen_count");

    Log.i("FB notificationsSummary", jsonObject + "");

    } catch (JSONException e) {             
        // TODO Auto-generated catch block
        e.printStackTrace();                        
    }


    Bundle notificationParams = new Bundle();
    notificationParams.putString("include_read", "true");
    yourRequest.setParameters(notificationParams);

    yourRequest.execute();
}