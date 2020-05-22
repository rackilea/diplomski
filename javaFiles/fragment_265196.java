Context context = this;
PackageManager packageManager = context.getPackageManager();

// if device support flash?
if (packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA_FLASH))
{
    //yes
    Log.i("camera", "This device has flash supported!");
 }else{
    //no
    Log.i("camera", "This device has no flash support!");
 }