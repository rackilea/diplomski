public static HashMap<Long,String> usernameMap = new HashMap<Long,String>();

public static void requestBatch(long[] batch,Twitter twitter) throws TwitterException
{
    ResponseList<User> responseList = twitter.lookupUsers(batch);
    for(User u : responseList){
        usernameMap.put(u.getId(), u.getScreenName());
    }
}