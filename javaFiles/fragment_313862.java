@TargetApi(Build.VERSION_CODES.M)
private void checkReadStoragePermission() {
    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.READ_EXTERNAL_STORAGE)) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_POSITIVE) {

                        ActivityCompat.requestPermissions(ParentActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, EXT_STORAGE_PERMISSION_REQ_CODE);


                    } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                        onPermissionsNotGranted();

                    }
                    dialog.dismiss();
                    finish();
                    startActivity(getIntent());
                }
            };
            new AlertDialog.Builder(this)
                    .setTitle(R.string.permissions_title)
                    .setMessage(R.string.read_ext_permissions_message)
                    .setPositiveButton(R.string.btn_continue, onClickListener)
                    .setNegativeButton(R.string.btn_cancel, onClickListener)
                    .setCancelable(false)
                    .show();
            return;
        }
        ActivityCompat.requestPermissions(ParentActivity.this, new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE, android.Manifest.permission.READ_PHONE_STATE}, EXT_STORAGE_PERMISSION_REQ_CODE);
        return;
    }

}

private void onPermissionsNotGranted() {
    Toast.makeText(this, R.string.toast_permissions_not_granted, Toast.LENGTH_SHORT).show();
    Log.v("tom", "JERRY");
}


@TargetApi(Build.VERSION_CODES.JELLY_BEAN)
private void checkwriteStoragePermission() {
    if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
        if (ActivityCompat.shouldShowRequestPermissionRationale(this, android.Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
            DialogInterface.OnClickListener onClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    if (which == DialogInterface.BUTTON_POSITIVE) {

                        ActivityCompat.requestPermissions(ParentActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE);
                        Log.v("tom", "TOM");
                    } else if (which == DialogInterface.BUTTON_NEGATIVE) {
                        onPermissionsNotGranted();
                        Log.v("tom", "JERRY");
                    }
                    dialog.dismiss();
                }
            };
            new AlertDialog.Builder(this)
                    .setTitle(R.string.permissions_title)
                    .setMessage(R.string.read_ext_permissions_message)
                    .setPositiveButton(R.string.btn_continue, onClickListener)
                    .setNegativeButton(R.string.btn_cancel, onClickListener)
                    .setCancelable(false)
                    .show();
            return;
        }
        ActivityCompat.requestPermissions(ParentActivity.this, new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, WRITE_EXTERNAL_STORAGE);
        return;
    }

}