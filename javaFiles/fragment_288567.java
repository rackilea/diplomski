@Override
public void onConfigurationChanged(final Configuration newConfiguration) {

      Log.wtf(
        "Orientation", 
        newConfiguration.orientation == Configuration.ORIENTATION_PORTRAIT 
             ? "portrait"
             : "landscape"
      );

}