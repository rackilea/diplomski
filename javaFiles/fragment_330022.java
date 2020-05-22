private void checkReadPhoneStatePermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (!hasGetReadPhoneStatePermission()) {
            requestReadPhoneStatePermission();
        }
    }
}