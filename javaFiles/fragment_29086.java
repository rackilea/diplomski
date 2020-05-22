@Override
public void onRequestPermissionsResult(int requestCode,
                                       String permissions[], int[] grantResults) {
    switch (requestCode) {
        case YOUR_INTEGER_CONSTANT_FOR_THE_CALLBACK: {
            // If request is cancelled, the result arrays are empty.
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.d(TAG,"Granted");
                // permission was granted, yay! Do the
                // contacts-related task you need to do.

            } else {
                Log.d(TAG,"Denied");
                // permission denied, boo! Disable the
                // functionality that depends on this permission.
            }
            return;
        }

        // other 'case' lines to check for other
        // permissions this app might request
    }
}