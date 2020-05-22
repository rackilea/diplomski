import android.content.pm.PackageManager;

public class PermissionsHelper {
    private String[] permissions;
    private int[] grantResults;

    public PermissionsHelper(String[] permissions, int[] grantResults) {
        this.permissions = permissions;
        this.grantResults = grantResults;
    }

    public boolean isPermissionGranted(String permission) {
        final int length = permissions.length;

        for(int i = 0; i < length; i++) {
            if(permissions[i].equals(permission)) {
                return grantResults[i] == PackageManager.PERMISSION_GRANTED;
            }
        }

        // if permission wasn't found, we weren't even asking for it, so we consider it
        // as granted
        return true;
    }

    public boolean arePermissionsGranted(String ... permissions) {
        for(String permission : permissions) {
            if(!isPermissionGranted(permission)) return false;
        }

        return true;
    }
}