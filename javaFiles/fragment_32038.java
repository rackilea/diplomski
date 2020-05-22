final IDs friendIds = twitter.getFriendsIDs(MyId, cursor);
final ResponseList<User> users = twitter.lookupUsers(friendIds.getIDs());

for (User u : users) {
    System.out.println(u.getScreenName());
}