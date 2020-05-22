void setup() {
  requestPermission("android.permission.WRITE_EXTERNAL_STORAGE", "checkPermission");
}

void checkPermission(boolean wasPermissionGranted){
    if (wasPermissionGranted)
        println("Hooray! I can now write to the local file system!");
    else 
        println("Oh no! I was not granted write permission =(");
}