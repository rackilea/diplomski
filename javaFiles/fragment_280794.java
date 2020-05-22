public class MainActivity implements MyLocCallbacks{

    private MyLocationListener mLocListener;

    onCreate(S...){
        mLocListener = new MyLocationListener(this);  //this for the interface
    }

    //This one is called by your Location Listener
    @Override
    onLocFound(double lat, double lng){
        startAnimation();
    }


    private void startAnimation(){
        //do here your startAnimation, 
        //before you could show a simple loading screen
    }
}