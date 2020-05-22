PackageManager pm = getPackageManager();
try {
String packageName = "com.example.package";
Intent launchIntent = pm.getLaunchIntentForPackage(packageName);
startActivity(launchIntent);
}
catch (Exception e1){}