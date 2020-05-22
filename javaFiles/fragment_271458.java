String yourPackageName = "com.apk.example"; // android package name
String packageName = getApplicationContext().getPackageName();

// can be different from your package name if you're using flavor
// in app.build.gradle, 
String yourApplicationId = "com.apk.example"; 

if(packageName.equals(yourPackageName) && BuildConfig.APPLICATION_ID.equals(yourApplicationId)) {
   // no problem here
} else {
   // app is tampered, do something
}