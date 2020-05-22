int requestCode = 0;

if (Build.VERSION.SDK_INT >= 23) {
    if(checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED){
        requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, requestCode);
    }
}