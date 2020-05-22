public class AdPreference extends Preference {

public AdPreference(Context context, AttributeSet attrs, int defStyle) {super    (context, attrs, defStyle);}
public AdPreference(Context context, AttributeSet attrs) {super(context, attrs);}
public AdPreference(Context context) {super(context);}

/** The view to show the ad. */
private static AdView adView;
private static View myCustomView;

/* Your ad unit id. Replace with your actual ad unit id. */
private static final String AD_UNIT_ID = "XXXXXXXXXXXXXXX";

@Override
protected View onCreateView(ViewGroup parent) {
    // this will create the linear layout defined in ads_layout.xml

    if (myCustomView==null)
    {

        View view = super.onCreateView(parent);

        Activity activity = (Activity)getContext();

        // Create an adView.

        adView = new AdView(activity);
        adView.setAdSize(AdSize.BANNER);
        adView.setAdUnitId(AD_UNIT_ID);
        //adView.

        ((LinearLayout)view).addView(adView);

        myCustomView = view;

        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device.
        AdRequest adRequest = new AdRequest.Builder()
            .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
            .build();

        // Start loading the ad in the background.
        adView.loadAd(adRequest);

    }
    return myCustomView;    
}

}