//for example, permission can be "android.permission.WRITE_EXTERNAL_STORAGE"
public boolean hasPermission(String permission) 
{
    try {
        PackageInfo info = getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_PERMISSIONS);
        if (info.requestedPermissions != null) {
            for (String p : info.requestedPermissions) {
                if (p.equals(permission)) {
                    return true;
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    return false;
}