Intent intent = getPackageManager().getLaunchIntentForPackage("com.package.name");
if (intent != null) {
    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    startActivity(intent);
} else {
    // Open GooglePlay link to install the app
}