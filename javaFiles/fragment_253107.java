TwitterStream twitterStream = new TwitterStreamFactory(new ConfigurationBuilder().setJSONStoreEnabled(true).build()).getInstance();

        twitterStream.setOAuthConsumer(StaticConstants.API_KEY, StaticConstants.API_SECRET);
        AccessToken token = new AccessToken(StaticConstants.TOKEN_KEY, StaticConstants.TOKEN_SECRET);
        twitterStream.setOAuthAccessToken(token);

        UserStreamListener listener = new UserStreamListener() {
            public void onStatus(Status status) {
                System.out.println("Status: " + status.getText());
                //do your action here
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice sdn) {
            }

            @Override
            public void onTrackLimitationNotice(int i) {
            }

            @Override
            public void onScrubGeo(long l, long l1) {
            }

            @Override
            public void onStallWarning(StallWarning sw) {
            }

            @Override
            public void onException(Exception excptn) {
            }

            @Override
            public void onDeletionNotice(long l, long l1) {
            }

            @Override
            public void onFriendList(long[] longs) {
            }

            @Override
            public void onFavorite(User user, User user1, Status status) {
                System.out.println("User:"+user.getScreenName());
                System.out.println("User1 :"+user1.getScreenName());
                System.out.println("Status: "+status.getText());
            }

            @Override
            public void onUnfavorite(User user, User user1, Status status) {
            }

            @Override
            public void onFollow(User user, User user1) {
            }

            @Override
            public void onDirectMessage(DirectMessage dm) {
            }

            @Override
            public void onUserListMemberAddition(User user, User user1, UserList ul) {
            }

            @Override
            public void onUserListMemberDeletion(User user, User user1, UserList ul) {
            }

            @Override
            public void onUserListSubscription(User user, User user1, UserList ul) {
            }

            @Override
            public void onUserListUnsubscription(User user, User user1, UserList ul) {
            }

            @Override
            public void onUserListCreation(User user, UserList ul) {
            }

            @Override
            public void onUserListUpdate(User user, UserList ul) {
            }

            @Override
            public void onUserListDeletion(User user, UserList ul) {
            }

            @Override
            public void onUserProfileUpdate(User user) {
            }

            @Override
            public void onBlock(User user, User user1) {
            }

            @Override
            public void onUnblock(User user, User user1) {
            }

        };
        twitterStream.addListener(listener);
        twitterStream.user();