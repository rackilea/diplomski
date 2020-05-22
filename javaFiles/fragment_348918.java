@Override
public void onConfigurationChanged (Configuration config) {

    super.onConfigurationChanged(config);

    switch(config.orientation) {

        case Configuration.ORIENTATION_LANDSCAPE:
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            ActivitiesCurrentContentView.requestLayout();
        break;

        case Configuration.ORIENTATION_PORTRAIT
            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN); 
            ActivitiesCurrentContentView.requestLayout();
        break;
    }

}