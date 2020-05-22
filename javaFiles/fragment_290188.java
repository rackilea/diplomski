for (long userId : userIds) { // presumably you have a list of users 

    try {

        // call twitter4j here and process results

    }
    catch (TwitterException e) {
        // do not throw if user has protected tweets, or if they deleted their account
        if (e.getStatusCode() == HttpResponseCode.UNAUTHORIZED ||
            e.getStatusCode() == HttpResponseCode.NOT_FOUND) {

            // log something here
        }
        else {
            throw e;
        }
    }
}