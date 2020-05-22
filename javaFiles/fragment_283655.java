public String loadIMEI(Context context) {
        //Context context = getActivity().getApplicationContext();
        //Activity activity = context instanceof Activity ? (Activity) context : null;
        //mActivity = activity;
        // Check if the READ_PHONE_STATE permission is already available.
        //this.context = getActivity().getApplicationContext();

        if (ActivityCompat.checkSelfPermission(context, Manifest.permission.READ_PHONE_STATE)
                != PackageManager.PERMISSION_GRANTED) {
            // READ_PHONE_STATE permission has not been granted.
            requestPermissions();
        } else {
            // READ_PHONE_STATE permission is already been granted.
            RecordedIMEI = permissionGrantedActions();
        }
        if(RecordedIMEI != null) {
            Log.i("loadIMEIService", "IMEI number returned!");
        }
        return RecordedIMEI;
    }