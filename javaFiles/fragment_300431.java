package com.example.fixit;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import com.loopj.android.http.*;
import android.util.Log;
public class MainActivity extends Activity {
    private static String TAG="MainActivity";
    private PersistentCookieStore myCookieStore;
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    AsyncHttpClient client = new AsyncHttpClient();
    myCookieStore = new PersistentCookieStore(this);
    client.setCookieStore(myCookieStore);
    client.get("http://www.google.com", new AsyncHttpResponseHandler() {
        @Override
        public void onSuccess(String response) {
            Log.i(TAG, response);
        }
    });
}

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.activity_main, menu);
    return true;
}
}