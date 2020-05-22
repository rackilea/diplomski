private void getFollowing() {   
     Twitter t = new TwitterFactory().getInstance();
     t.setOAuthConsumer(OAUTH.CONSUMER_KEY, OAUTH.CONSUMER_SECRET);
     aToken = getToken();
     t.setOAuthAccessToken(aToken);
     ArrayList<String> names = new ArrayList<String>();
     try {
        int start = 0;
        int finish = 100;
        ArrayList<Long> IDS = new ArrayList<Long>();
        long[] friendsID =  t.getFriendsIDs(userID, -1).getIDs();
        boolean check = true;
        while (check) {
            for (int i=start;i<finish;i++) {
                //get first 100     
                IDS.add(friendsID[i]);
                //if at the end, stop
                if (friendsID.length-1 == i) {
                    check = false;
                    break;                      
                }
            }
            //set values for next 100
            start = start+100;
            finish = finish+100;
            long[] ids = Longs.toArray(IDS);
            ResponseList<User> userName = t.lookupUsers(ids);
            //clear so long[] holds max 100 at any given time
            IDS.clear();
            for (User u : userName) {
                names.add(u.getScreenName());
            }
        }
        String[] screenNames = (String[]) names.toArray(new String[names.size()]);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line, screenNames);
        mPreview.setAdapter(adapter);
     } catch (TwitterException e) {
        e.printStackTrace();
    }
}