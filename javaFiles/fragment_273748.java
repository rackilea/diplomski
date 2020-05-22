package com.ingage.pocs.phonegap;

    import android.app.Activity;
    import android.content.Intent;
    import android.net.Uri;
    import android.os.Bundle;

    public class OpenURL extends Activity{

        @Override
protected void onCreate(Bundle savedInstanceState) {
    // TODO Auto-generated method stub
    super.onCreate(savedInstanceState);
    DebugLog.LOGD("Within BookTicketsActivity Activity GO button ");

    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.thecinema.in"));
    startActivity(browserIntent);

}