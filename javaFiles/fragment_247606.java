int permissionCheck = ContextCompat.checkSelfPermission(this, 
                                         Manifest.permission.CALL_PHONE);

if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
    ActivityCompat.requestPermissions(
            this,
            new String[]{Manifest.permission.CALL_PHONE},
            999);
} else {
    startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel: your_phone_number")));
}

@Override
public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
    switch (requestCode) {

        case 999:
            if ((grantResults.length > 0) && (grantResults[0] == PackageManager.PERMISSION_GRANTED)) {
                startActivity(new Intent(Intent.ACTION_CALL).setData(Uri.parse("tel:your_phone_number")));
            } 
            break;

        default:
            break;
    }
}