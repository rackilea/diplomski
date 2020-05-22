public BlueToothConnThread extends Activity {

    @Override
    public void onCreate(Bundle onSavedInstanceState) {
     //Some code

    Bundle dataBundle = getIntent().getExtras();    
    deviceList = dataBundle.getStringArrayList("DeviceList");
    }
}