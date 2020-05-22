if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED){
   requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION},
                 PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION);
    //After this point you wait for callback in onRequestPermissionsResult(int, String[], int[]) overriden method

}else{
    getScanningResults();
   //do something, permission was previously granted; or legacy device
}



@Override
 public void onRequestPermissionsResult(int requestCode, String[] permissions,
         int[] grantResults) {
     if (requestCode == PERMISSIONS_REQUEST_CODE_ACCESS_COARSE_LOCATION
             && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
         // Do something with granted permission
        mWifiListener.getScanningResults();
     }
 }