import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

       AdView adView = new AdView(this);
       adView.setAdSize(AdSize.BANNER);
       adView.setAdUnitId(AD_UNIT_ID);
       AdRequest adRequest = new AdRequest.Builder().build();
       adView.loadAd(adRequest);