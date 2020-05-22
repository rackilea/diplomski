...
//changed the identifiers from private to public static and the class extends //BroadcastReceiver
public static class ProviderChangeReceiver_updateUI extends BroadcastReceiver {

    //Empty constructor to prevent exception can't instantiate no empty constructor
    public ProviderChangeReceiver_updateUI(){

    }

    //Removed the final keyword from handler
    private Handler handler; // Handler used to execute code on the UI thread

    public ProviderChangeReceiver_updateUI(Handler handler) {
        this.handler = handler;
    }

    @Override
    public void onReceive(final Context context, final Intent intent) {
        boolean isProvidrActv = intent.getBooleanExtra("isProvidrActv", false);
        //mapsActivity is a global static object of the class MapsActivity<br/>
        //instantiate it the onCreate() method of mainactivity for ex:<br/>
/*public class MapsActivity extends Activity{<br/>
         static MapsActivity mapsActivity;

         @Override
         protected void onCreate(Bundle savedInstancestate){
        ma  = new MapsActivity();
        }*/
        mapsActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (isProvidrActv)
                    originButton.setVisibility(View.VISIBLE);
                else
                    originButton.setVisibility(View.INVISIBLE);
            }
        });
    }
}