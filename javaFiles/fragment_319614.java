public void onClick(View v) {
    String number = "18002738255";
    Uri call = Uri.parse("tel:" + number);
    Intent surf = new Intent(Intent.ACTION_CALL, call);
    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        return;
    }
    startActivity(surf);
}