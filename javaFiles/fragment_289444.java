class MyService..{
   public BeaconNotificationsManager bnm;
   public class LocalBinder extends Binder {
        LocalService getService() {
            // Return this instance of LocalService so clients can call public methods
            return LocalService.this;
        }
    }

    @Override
    public IBinder onBind(Intent intent) {
        return mBinder;
    }

   // inside service class
    public boolean getStatus(){
     return bnm==null;
    }
}