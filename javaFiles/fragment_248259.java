List<String> permissions = new ArrayList<String>();

private boolean askPermission() {


    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        int RECORD_AUDIO = checkSelfPermission(Manifest.permission.RECORD_AUDIO );

        if (RECORD_AUDIO != PackageManager.PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.RECORD_AUDIO);
        }


        if (!permissions.isEmpty()) {
            requestPermissions(permissions.toArray(new String[permissions.size()]), 1);
        } else
            return false;
    } else
        return false;
    return true;

}

@Override
public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
    if (requestCode == 1) {

        boolean result = true;
        for (int i = 0; i < permissions.length; i++) {
            result = result && grantResults[i] == PackageManager.PERMISSION_GRANTED;
        }
        if (!result) {

            Toast.makeText(this, "..", Toast.LENGTH_LONG).show();
           // askPermission();
        } else {
        }
    }
    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
}