private void checkReadPhoneStatePermission() {
    if (Build.VERSION.SDK_INT >= 23) {
        if (!hasGetReadPhoneStatePermission()) {
            requestReadPhoneStatePermission();
        }
    }
}