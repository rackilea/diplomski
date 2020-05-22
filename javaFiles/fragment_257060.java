public class PostTweetDialog extends DialogFragment  {
    private RestClient client;
    private PostTweetInterface dialogFragment;
    ArrayList<Tweet> tweets;
    TweetArrayAdapter adapter;

    public PostTweetDialog(RestClient client) {
        this.client = client;
    }

    ...
}