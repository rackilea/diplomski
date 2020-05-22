@Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    listFile = dir.listFiles();
    ...
    if (listFile == null || listFile.length == 0) {
        Toast.makeText(MainActivity.this, "The folder is empty.", Toast.LENGTH_SHORT).show();
    } else {
        new MainActivity.SingleMediaScanner(MainActivity.this, listFile[0]);
    }
    ...
}