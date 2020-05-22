String twitterScreenName = twitter.getScreenName();
PagableResponseList<User> statuse = twitter.getFollowersList(twitterScreenName, -1);
            for (User follower : statuse) {

                System.out.println(follower.getName()); 
            }