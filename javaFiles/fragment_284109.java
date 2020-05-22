// implements OnBatteryChange in your activity
    public class MainActivity extends AppCompatActivity implements OnBatteryChange {...
    // add following method in your activity
     @Override
      public void batteryChanged(String data) {
        txtBat.setText(data);
      }
    // add following line in onCreate() in activity

    OtherReceiver reciever = new OtherReceiver(getApplicationContext(),this);
    reciever.doSomethingWithReceivedIntent();

        //OtherReceiver class

        public class OtherReceiver {
    Context context;
    OnBatteryChange batteryChange;

    public OtherReceiver(Context context, OnBatteryChange batteryChange) {
        this.context = context;
        this.batteryChange = batteryChange;
    }

    public void doSomethingWithReceivedIntent() {
        BatteryReceiver batteryReceiver = new BatteryReceiver();
        batteryReceiver.setBatteryChange(batteryChange);
        context.registerReceiver(batteryReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
    }
}

    //OnBatteryChange interface

    public interface OnBatteryChange {
        void batteryChanged(String data);
    }

    //amend BatteryReceiver to following code 
public class BatteryReceiver extends BroadcastReceiver {
    OnBatteryChange batteryChange;

    public void setBatteryChange(OnBatteryChange batteryChange) {
        this.batteryChange = batteryChange;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        int deviceStatus = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
        int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, -1);
        int scale = intent.getIntExtra(BatteryManager.EXTRA_SCALE, -1);
        int percentage = (int) (((float) level / (float) scale) * 100.0f);

        switch (deviceStatus) {
            case BatteryManager.BATTERY_STATUS_CHARGING:

                batteryChange.batteryChanged(context.getString((R.string.bat_charge), "Charging:", percentage, "%"));
                break;
            case BatteryManager.BATTERY_STATUS_DISCHARGING:

                batteryChange.batteryChanged(context.getString((R.string.bat_charge), "Discharging:", percentage, "%"));
                break;
            case BatteryManager.BATTERY_STATUS_FULL:

                batteryChange.batteryChanged(context.getString((R.string.bat_charge), "Full:", percentage, "%"));
                break;
            case BatteryManager.BATTERY_STATUS_UNKNOWN:

                batteryChange.batteryChanged(context.getString((R.string.bat_charge), "Unknown:", percentage, "%"));
                break;
            case BatteryManager.BATTERY_STATUS_NOT_CHARGING:

                batteryChange.batteryChanged(context.getString((R.string.bat_charge), "Not charging:", percentage, "%"));
                break;
        }
    }

}