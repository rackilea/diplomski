public void checkDrawPermission() {
    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
        if (!Settings.canDrawOverlays(this)) {
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION,
                    Uri.parse("package:" + getPackageName()));
            startActivityForResult(intent, 123);
        } else {
            // display over lay from service
            startService(new Intent(getApplicationContext(), MyService.class));
        }
    }else
    {
        // display over lay from service
        startService(new Intent(getApplicationContext(), MyService.class));
    }
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode,resultCode,data);
    if (requestCode == 123) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (Settings.canDrawOverlays(this)) {
                // You have permission
                // display over lay from service
                startService(new Intent(getApplicationContext(), MyService.class));
            }
        }
    }
}