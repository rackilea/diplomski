public class UserDAO { // no need to extend and changed name to UserDAO

    public List<User> retainTopUsersItems(int maxNumOfReturnedResources, List<User> userList) {
        List<User> retainList = new ArrayList<User>();
        for (int i = 0; i < maxNumOfReturnedResources; i++) {
            retainList.add(userList.get(i));
        }
        return retainList;
    }

    public List<User> loadFromDatabase() {
        Connection userinfoCon = null;
        ResultSet userinfoRS = null;
        List<User> userlist = new ArrayList<>();