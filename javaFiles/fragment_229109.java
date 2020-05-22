public void returnFriendIDs(final int pointer)
{
    runOnUiThread(new Runnable()
    {
        @Override
        public void run()
        {
            Properties properties = new Properties.Builder()
            .add(Profile.Properties.ID)
            .add(Profile.Properties.FIRST_NAME)
            .add(Profile.Properties.LAST_NAME)
            .add(Profile.Properties.INSTALLED)
            .build();

            try{
                mSimpleFacebook.getFriends(properties,  new OnFriendsListener() {
                    @Override
                    public void onComplete(List<Profile> friends) {
                        String resultStr = "";
                        Log.d(LOGPREFIX, "Number of friends = " + friends.size());
                        for(Profile p : friends){
                            resultStr += p.getId()+',';
                        }
                        if(friends.size() > 0) returnFriends(pointer, resultStr.substring(0,resultStr.length()-1));
                        else returnFriends(pointer, "");
                    }

                    @Override
                    public void onFail(String reason){
                        returnFriends(pointer, "");
                    }

                    @Override
                    public void onException(Throwable throwable){
                        Log.w(LOGPREFIX, throwable.getMessage());
                        returnFriends(pointer, "");
                    }
                });
            }
            catch(Throwable throwable){
                Log.w(LOGPREFIX, "In getFriends"+throwable.getMessage());
            }
        }
    });
}