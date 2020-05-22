private boolean doLocationsCheck(){
    if(!checkLocationEnabled()){

        final CharSequence[] items = {"Yes", "No"};

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setCancelable(false);
        builder.setTitle("Location must be enabled to play this game! Would you like to enable it now?");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int item) {
                final int i = item;
                runOnUiThread(new Runnable() {
                    public void run() {                         
                        if(i == 0){
                            Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                            startActivity(intent);
                            quit();
                        }
                        else{
                            quit();
                        }

                    }
                });
            }


        }).show();
        AlertDialog alert = builder.create();

        return false;

    }
    else {
        return true;
    }
}

private boolean checkLocationEnabled(){

    LocationManager service = (LocationManager) getSystemService(LOCATION_SERVICE);
    boolean enabled = service.isProviderEnabled(LocationManager.GPS_PROVIDER) || service.isProviderEnabled(LocationManager.NETWORK_PROVIDER);

    return enabled;
}