// function for service testing
public void onStartButtonClick(View view) {
    Intent myIntentToStartAlertListActivity = new Intent(LoginActivity.this,AlertService.class);
    String pkg = "nl.test.app.messaging";
    String cls = "nl.test.app.messaging.AlertService";
    myIntentToStartAlertListActivity.setComponent(new ComponentName(pkg, cls));
    //startService(myIntentToStartAlertListActivity)

 if (startService(myIntentToStartAlertListActivity) != null) {
        Log.i("Service Started","Service started");
        Toast.makeText(getApplicationContext(), "Service is running\n", Toast.LENGTH_LONG).show();
    }
    else {
        Toast.makeText(getApplicationContext(), "Service is not running\n", Toast.LENGTH_LONG).show();
    }
}