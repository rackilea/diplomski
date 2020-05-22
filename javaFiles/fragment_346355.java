private static int counter = 0;
private static YouTube youtube;

public static void main(String[] args) throws Exception {
    // For Auth details consider:
    // https://github.com/youtube/api-samples/blob/master/java/src/main/java/com/google/api/services/samples/youtube/cmdline/Auth.java
    // Also don't forget secrets https://github.com/youtube/api-samples/blob/master/java/src/main/resources/client_secrets.json
    List<String> scopes = Lists.newArrayList("https://www.googleapis.com/auth/youtube.force-ssl");
    Credential credential = Auth.authorize(scopes, "commentthreads");
    youtube = new YouTube.Builder(Auth.HTTP_TRANSPORT, Auth.JSON_FACTORY, credential).build();

    String videoId = "video_id";

    // Get video comments threads
    CommentThreadListResponse commentsPage = prepareListRequest(videoId).execute();

    while (true) {
        handleCommentsThreads(commentsPage.getItems());

        String nextPageToken = commentsPage.getNextPageToken();
        if (nextPageToken == null)
            break;

        // Get next page of video comments threads
        commentsPage = prepareListRequest(videoId).setPageToken(nextPageToken).execute();
    }

    System.out.println("Total: " + counter);
}

private static YouTube.CommentThreads.List prepareListRequest(String videoId) throws Exception {

    return youtube.commentThreads()
                  .list("snippet,replies")
                  .setVideoId(videoId)
                  .setMaxResults(100L)
                  .setModerationStatus("published")
                  .setTextFormat("plainText");
}

private static void handleCommentsThreads(List<CommentThread> commentThreads) {

    for (CommentThread commentThread : commentThreads) {
        List<Comment> comments = Lists.newArrayList();
        comments.add(commentThread.getSnippet().getTopLevelComment());

        CommentThreadReplies replies = commentThread.getReplies();
        if (replies != null)
            comments.addAll(replies.getComments());

        System.out.println("Found " + comments.size() + " comments.");

        // Do your comments logic here
        counter += comments.size();
    }
}