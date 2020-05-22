private static final int GRANTED = PackageManager.PERMISSION_GRANTED;

if (checkCoarseLocationPermission(getActivity()) &&  checkFineLocationPermission(getActivity())) {
        //permissions are granted
    }else {
        requestLocationPermission(getActivity());
    }
}

public boolean checkCoarseLocationPermission(Activity mActivity){
    int permissionCheck = ContextCompat.checkSelfPermission(mActivity,
            Manifest.permission.ACCESS_COARSE_LOCATION);
    return permissionCheck == GRANTED;
}

public boolean checkFineLocationPermission(Activity mActivity){
    int permissionCheck = ContextCompat.checkSelfPermission(mActivity,
            Manifest.permission.ACCESS_FINE_LOCATION);
    return permissionCheck == GRANTED;
}

public void requestLocationPermission(Activity mActivity){
    ActivityCompat.requestPermissions(mActivity,
            new String[]{Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION},
            MY_PERMISSIONS_REQUEST_LOCATION);
}