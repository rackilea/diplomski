public void getFriends(CharSequence[] charFriendsNames,String[] sFriendsID, ProgressBar progbar) {
    try{
        //Pass arrays to store data
        friends = charFriendsNames;
        friendsID = sFriendsID;
        pb = progbar;
        Log.d(TAG, "Getting Friends!");
        //Create Request with Friends Request Listener
        mAsyncRunner.request("me/friends", new FriendsRequestListener());
    } catch (Exception e) {
        Log.d(TAG, "Exception: " + e.getMessage());
    }
}