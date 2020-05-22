@Override
public void onTaskStarted() {
    lockScreenOrientation();
    progressDialog = ProgressDialog.show(CopyOfCopyOfMainActivity.this, "Loading", "Please wait a moment!");
}

@Override
public void onTaskFinished(String result) {
    if (progressDialog != null) {
        progressDialog.dismiss();
    }
    unlockScreenOrientation();
}

private void lockScreenOrientation() {
    int currentOrientation = getResources().getConfiguration().orientation;
    if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    } else {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }
}

private void unlockScreenOrientation() {
    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
}