import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
 @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {
                    @Override
                    protected String doInBackground(Void... params) {
                        AdvertisingIdClient.Info idInfo = null;
                        try {
                            idInfo = AdvertisingIdClient.getAdvertisingIdInfo(getApplicationContext());
                        } catch (GooglePlayServicesNotAvailableException e) {
                            e.printStackTrace();
                        } catch (GooglePlayServicesRepairableException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        String advertId = null;
                        try{
                            advertId = idInfo.getId();
                        }catch (NullPointerException e){
                            e.printStackTrace();
                        }

                        return advertId;
                    }

                    @Override
                    protected void onPostExecute(String advertId) {
                        Toast.makeText(getApplicationContext(), advertId, Toast.LENGTH_LONG).show();
                    }

                };
                task.execute();

}

}