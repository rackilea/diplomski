Intent notifIntent = new Intent();
notifIntent.setAction("android.settings.APP_NOTIFICATION_SETTINGS");

//for Android 5-7
notifIntent.putExtra("app_package", getPackageName());
notifIntent.putExtra("app_uid", getApplicationInfo().uid);

// for Android 8
notifIntent.putExtra("android.provider.extra.APP_PACKAGE", getPackageName());

startActivity(notifIntent);