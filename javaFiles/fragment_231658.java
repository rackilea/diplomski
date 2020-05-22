long userId = 0000000L;

     try 
     {
        ResponseList<Status> statusList = twitterObj.timelines().getUserTimeline(userId);

        for (Status statusItem : statusList)
        {
         System.out.println("Tweet Id : " + statusItem.getId() + ", retweet count: " + statusItem.getRetweetCount());
        }               
     } 
     catch (TwitterException ex) 
     {
        // Do error handling things here
     }