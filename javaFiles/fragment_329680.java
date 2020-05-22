long cursor = -1;
PagableResponseList<User> followers;
do {
     followers = twitter.getFollowersList("screenName", cursor);
    for (User follower : followers) {
        // TODO: Collect top 10 followers here
        System.out.println(follower.getName() + " has " + follower.getFollowersCount() + " follower(s)");
    }
} while ((cursor = followers.getNextCursor()) != 0);