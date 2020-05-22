class PermissionsHelper(activity: Activity) {
private val activity: Context

init { this.activity = activity }

fun isCameraPermissionAvailable()=ActivityCompat.checkSelfPermission(activity, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED