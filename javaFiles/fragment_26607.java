import android.net.Uri;

//...
Intent intent = new Intent (StayActiveActivity.this, WebViewActivity.class);
intent.setData(Uri.parse("your-url"));
StayActiveActivity.this.startActivity(intent);