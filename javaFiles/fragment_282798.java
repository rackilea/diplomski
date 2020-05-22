import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.core.app.JobIntentService;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import java.util.ArrayList;
import java.util.List;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.AccessToken;

public class TweetJobIntentService extends JobIntentService {
    private static final String TAG = "TweetJobIntentService";

    static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, TweetJobIntentService.class, 123, work);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate: ");

    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {
        Log.d(TAG, "onHandleWork: ");
        List tweets = new ArrayList();
        Twitter twitter = new TwitterFactory().getInstance();
        twitter.setOAuthConsumer("Your_OAuthConsumerKey", "Your_AuthConsumerSecret");
        AccessToken accessToken = new AccessToken("Your_OAuthAccessToken", "Your_OAuthAccessTokenSecret");
        twitter.setOAuthAccessToken(accessToken);
        Query query = new Query(Your_search_Keyword);
        try {
            QueryResult result = twitter.search(query);
            for (Status status : result.getTweets()) {
                Log.d(TAG, status.getText());

            }
            if (isStopped()) return;
        } catch (TwitterException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDeastroy");
    }

    @Override
    public boolean onStopCurrentWork() {
        Log.d(TAG, "onStopCurrentWork");
        return super.onStopCurrentWork();
    }
}