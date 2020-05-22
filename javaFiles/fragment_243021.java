try {
                Twitter twitter = new TwitterFactory().getInstance();
                long cursor = -1;
                IDs ids;

                System.out.println("Listing followers's ids.");
                do {
                    if (0 < userId) {
                        ids = twitter.getFollowersIDs(userId, cursor);
                    } else {
                        ids = twitter.getFollowersIDs(cursor);
                    }
                    for (long id : ids.getIDs()) {
                        System.out.println(id);
                    }
                } while ((cursor = ids.getNextCursor()) != 0);
                System.exit(0);
            } catch (TwitterException te) {
                te.printStackTrace();
                System.out.println("Failed to get followers' ids: " + te.getMessage());
                System.exit(-1);
            }