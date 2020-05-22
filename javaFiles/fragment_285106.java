package com.example.packagename;

     import com.google.ads.AdRequest;
     import com.google.ads.AdView;


     import android.os.Handler;

     public class ClassName extends Activity {

        private AdRequest re;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            setContentView(R.layout.main);
            final AdView adview = (AdView) findViewById(R.id.adView);
            re = new AdRequest();
            adview.loadAd(re);

            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                public void run() {
                    re = new AdRequest();

                    adview.loadAd(re);
                    handler.postDelayed(this, 15000);
                }
            }, 15000);

            --rest of code
        }