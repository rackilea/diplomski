String encodedHash = Uri.encode("#");
    i.setData(Uri.parse("tel:"+"*100"+encodedHash));

    if (ActivityCompat.checkSelfPermission(this,
            Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
        return;
    }
    startActivity(i);