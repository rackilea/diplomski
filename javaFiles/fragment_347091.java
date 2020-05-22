try {
        Query query = new Query(keyword); //

        GeoLocation location = new GeoLocation(latitude, longitude);
        String unit = Query.KILOMETERS; // or Query.MILES;
        query.setGeoCode(location, radius, unit);

        QueryResult result; 

        do {
            result = twitter.search(query);
            List<Status> tweets = result.getTweets();

            for (Status tweet : tweets) {
                System.out.println("@" + tweet.getUser().getScreenName() + " - " + tweet.getText());
            }

        } while ((query = result.nextQuery()) != null);

    } catch (TwitterException te) {
        System.out.println("Failed to search tweets: " + te.getMessage());
        System.exit(-1);
    }