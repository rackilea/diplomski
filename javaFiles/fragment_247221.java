private class FriendsRequestListener implements RequestListener {
    String friendData;

    //Method runs when request is complete
    public void onComplete(String response, Object state) {
        Log.d(TAG, "FriendListRequestONComplete");
        //Create a copy of the response so i can be read in the run() method.
        friendData = response; 

        //Create method to run on UI thread
        FBConnectActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                try {
                    //Parse JSON Data
                    JSONObject json;
                    json = Util.parseJson(friendData);

                    //Get the JSONArry from our response JSONObject
                    JSONArray friendArray = json.getJSONArray("data");

                    //Loop through our JSONArray
                    int friendCount = 0;
                    String fId, fNm;
                    JSONObject friend;
                    for (int i = 0;i<friendArray.length();i++){
                        //Get a JSONObject from the JSONArray
                        friend = friendArray.getJSONObject(i);
                        //Extract the strings from the JSONObject
                        fId = friend.getString("id");
                        fNm = friend.getString("name");
                        //Set the values to our arrays
                        friendsID[friendCount] = fId;
                        friends[friendCount] = fNm;
                        friendCount ++;
                        Log.d("TEST", "Friend Added: " + fNm);
                    }

                    //Remove Progress Bar
                    pb.setVisibility(ProgressBar.GONE);

                } catch (JSONException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                } catch (FacebookError e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }