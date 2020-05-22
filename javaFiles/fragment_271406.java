public static GetForumTopicsByCreatorAdapter getInstance(List<Topic> topics) {

   // two checks for null 
    if (sInstance == null) { //one here
        synchronized (GetForumTopicsByCreatorAdapter.class) {
            if (sInstance == null) {  //and one here
                sInstance = new GetForumTopicsByCreatorAdapter(topics);
                sInstance.notifyDataSetChanged();
            }  else  {
                sInstance.setTopics(topics);
            }
        }
    }
    /// at this point, if instance was not null, nothing is done on it and is returned as is.
     /// So new items are not added.
    return sInstance;
}