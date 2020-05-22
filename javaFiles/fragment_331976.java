public class MySensorActivity extends Activity implements SensorEventListener {


public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ...
        loopThread();
}

  private void loopThread() {
        boolean found = kill;
        System.out.println("Looping until Found!");
        locationThread = new Thread(){
                private float myacc;

                @Override
                @Override
                public void run() {

                        while (found == false && !kill){
                                System.out.println("Another Loop!");
                                getMyLoc();
                                found = isFound(mylat,mylng,target_lat,target_lng,radius);
                                try {
                                        synchronized(locationThread){
                                                locationThread.wait(100);
                                        }

                                } catch (InterruptedException e) {
                                        // TODO Auto-generated catch block
                                        e.printStackTrace();
                                }
                        }
                        mSensorManager.unregisterListener(this, mAccelerometer);
                        mSensorManager.unregisterListener(this, mGravitometer);
                        mSensorManager.unregisterListener(this);
                        locationThread.interrupt();
                }
}

@Override
public void onPause(){
        super.onPause();
        mSensorManager.unregisterListener(this, mAccelerometer);
        mSensorManager.unregisterListener(this, mGravitometer);
        locationThread.interrupt();
}
@Override
public void onResume(){
        super.onResume();
        registerSensors();
        mSensorManager.registerListener(this, mAccelerometer,     SensorManager.SENSOR_DELAY_NORMAL);
        mSensorManager.registerListener(this, mGravitometer, SensorManager.SENSOR_DELAY_NORMAL);
        if (true)
                loopThread();
}

private void registerSensors() {
        mSensorManager =     (SensorManager)context.getSystemService(Context.SENSOR_SERVICE);
        List<Sensor> mySensors = mSensorManager.getSensorList(Sensor.TYPE_ORIENTATION);
        if(mySensors.size() > 0){
                mAccelerometer =     mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
                mGravitometer =     mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

                mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
                mSensorManager.registerListener(this, mGravitometer, SensorManager.SENSOR_DELAY_NORMAL);
                Toast.makeText(context, "Getting your location...", Toast.LENGTH_LONG).show();
        }
        else{
                Toast.makeText(context, "No ORIENTATION Sensor", Toast.LENGTH_LONG).show();
        }
}


 public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
                Intent i = new Intent(this, MFLMain.class);
                if (locationThread != null)
                        if(locationThread.isAlive()){

                mSensorManager.unregisterListener(this, mAccelerometer);
                mSensorManager.unregisterListener(this, mGravitometer);
                mSensorManager.unregisterListener(this);
                locationThread.interrupt();
                        }
                locator.stopListener();
                kill = true;
                System.out.println("Kill the app "+kill);
                finish();
                startActivity(i);
                return false;
        }
        return super.onKeyDown(keyCode, event);
}