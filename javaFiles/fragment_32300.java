override fun onResume() {
    super.onResume()
    if (!PermissionsHelper(this).isCameraPermissionAvailable()) {
        requestPermissions(arrayOf(Manifest.permission.CAMERA), CAMERA_REQUEST_CODE)
    }
}