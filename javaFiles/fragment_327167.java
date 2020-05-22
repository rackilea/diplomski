public class UserListSource {
     private String userList = null;
     private long lastFetched;
     private static long MAX_AGE = 1000 * 60 * 5; // 5 mins

     public String get() {
        if(userList == null || currentTimeMillis() > lastFetched + MAX_AGE) {
             userList = fetchUserListUsingThirdPartyApi();
             fetched = currentTimeMillis();
        }
        return userList;
     }
 }