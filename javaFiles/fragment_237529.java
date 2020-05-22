String[] permissions = {"android.permission.CAMERA"};
int permissionRequestCode = 200;
if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(permissions[0]) != PackageManager.PERMISSION_GRANTED)
    {
        requestPermissions(permissions, permissionRequestCode);
    }