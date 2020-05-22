fun Context.toast(message: CharSequence) =
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()

fun Context.arePermissionsGranted(permissions: Array<String>): Boolean {
    permissions.forEach { it ->
        if(ActivityCompat.checkSelfPermission(this, it) != PackageManager.PERMISSION_GRANTED)
            return false
    }
    return true
}

    fun Context.isPermissionGranted(permission: String) =
            ActivityCompat.checkSelfPermission(this, permission) == PackageManager.PERMISSION_GRANTED

    fun Context.batchRequestPermissions(permissions: Array<String>, requestId: Int) =
            ActivityCompat.requestPermissions(this as Activity, permissions, requestId)

    fun Context.requestPermission(permission: String, requestId: Int) =
            ActivityCompat.requestPermissions(this as Activity, arrayOf(permission), requestId)