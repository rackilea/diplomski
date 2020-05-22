final UserTimeline userTimeline = new UserTimeline.Builder()
                    .screenName(userScreenName).build(); //creating user timeline

final TweetTimelineListAdapter adapter = new TweetTimelineListAdapter.Builder(this)
 .setTimeline(userTimeline).build(); 

setListAdapter(adapter); //adapter for fetching tweets