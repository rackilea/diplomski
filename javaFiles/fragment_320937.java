import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.nestapi.codelab.demo.R;
import com.nestapi.codelab.demo.Settings;
import com.nestapi.lib.API.*;

public class Activity4Test extends Activity implements
    NestAPI.AuthenticationListener, Listener.ThermostatListener {

    private Listener mUpdateListener;
    private NestAPI mNestApi;
    private Thermostat mThermostat;
    private AccessToken mToken;

    TextView txvGet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4test);
        mNestApi = NestAPI.getInstance();//Initial NestAPI, connect Firebase
        mToken = Settings.loadAuthToken(this);//Loade AccessToken
        authenticate(mToken);

        txvGet = (TextView) findViewById(R.id.txvGet);
    }

    private void authenticate(AccessToken token) {
        Log.v("Activity4Test", "Authenticating...");
        NestAPI.getInstance().authenticate(token, this);
    }

    @Override
    public void onAuthenticationSuccess() {
        Log.v("Activity4Test", "Authentication succeeded.");
        fetchData();
    }

    @Override
    public void onAuthenticationFailure(int errorCode) {
        Log.v("Activity4Test", "Authentication failed with error: " + errorCode);
    }

    private void fetchData() {
        Log.v("Activity4Test", "Fetching data...");

        mUpdateListener = new Listener.Builder()
                .setThermostatListener(this)
                .build();
        mNestApi.addUpdateListener(mUpdateListener);
    }

    @Override
    public void onThermostatUpdated(@NonNull Thermostat thermostat) {
        Log.v("Activity4Test", String.format("Thermostat (%s) updated.", thermostat.getDeviceID()));
        mThermostat = thermostat;
    }