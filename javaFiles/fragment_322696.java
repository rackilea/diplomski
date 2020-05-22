public class MyApplication extends Application {

    private SensorProcessor mSensorProcessor = null;

     public SensorProcessor getCurrentSensorProcessor(){
        return mSensorProcessor;
     }

      public void setSensorProcessor(SensorProcessor mSensorProcessor){
          this.mSensorProcessor = mSensorProcessor;
     }