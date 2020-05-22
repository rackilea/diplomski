@Override
public void onBackPressed() {
    Bundle extras = getIntent().getExtras();

    boolean launchedFromNotif = false;

    if (extras.containsKey("EXTRA_LAUNCHED_BY_NOTIFICATION")) {
        launchedFromNotif = extras.getBoolean("EXTRA_LAUNCHED_BY_NOTIFICATION");
    }

    if (launchedFromNotif) {
        // Launched from notification, handle as special case
        Intent intent = new Intent(this, MainScreenActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        mActivity.startActivity(intent);
        finish();
    } else {
        super.onBackPressed();
    }
}