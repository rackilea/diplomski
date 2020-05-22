@Override
public void onConfigurationChanged(Configuration myConfig) {
    super.onConfigurationChanged(myConfig);
    int orient = getResources().getConfiguration().orientation; 
    switch(orient) {
        case Configuration.ORIENTATION_LANDSCAPE:
            // handle landscape here
            break;
        case Configuration.ORIENTATION_PORTRAIT:
            // handle portrait here
            break;
        default:
        }
}