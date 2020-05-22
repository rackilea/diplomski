dialogBuilder.setView(inflater.inflate(R.layout.dialog_location, null))
            .setNeutralButton("Use Current Location", null);

final AlertDialog locationDialog = dialogBuilder.create();

locationDialog.setOnShowListener(new DialogInterface.OnShowListener() {

        @Override
        public void onShow(DialogInterface dialog) {

            Button button = ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_NEUTRAL);
            button.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View view) {
                    EditText latitude = (EditText) locationDialog.findViewById(R.id.dl_et_latitude);
                    EditText longitude = (EditText) locationDialog.findViewById(R.id.dl_et_longitude);
                    LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
                    try {
                        Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                        double currentLongitude = location.getLongitude();
                        double currentLatitude = location.getLatitude();
                        latitude.setText(Double.toString(currentLatitude));
                        longitude.setText(Double.toString(currentLongitude));
                        Log.d(TAG, "Latitude " + currentLatitude + "  Longitude " + currentLongitude);
                    } catch (SecurityException e){
                        Log.d(TAG, e.toString());
                    }
                }
            });
        }
    });