public class MyLocationListener extends LocationListener{

    public interface MyLocCallbacks{
        onLocFound(double lat, double lng);
    }

    private MyLocCallbacks mCallbacks;

    public MyLocationListener(MyLocCallbacks callback){
        this.mCallbacks = callback;

        //Make sure to start the LocationSerivce here
    }   

    public void onLocationChanged(final Location loc) {
        this.mCallbacks.onLocFound(log.getLatitude(), loc.getLongitude()) 
    }

}