Button getTaxi = (Button) findViewById(R.id.GetTaxi);
getTaxi.setOnClickListener(new View.OnClickListener() {


    Toast toast;

    public void getAddress() {
        Geocoder geocoder = new Geocoder(getBaseContext(), Locale.getDefault());   
        String result = null;
        try {
            List<Address> list = geocoder.getFromLocation(
                    location.getLatitude(), location.getLongitude(), 1);
            if (list != null && list.size() > 0) {
                Address address = list.get(0);
                // sending back first address line and locality
                result = address.getAddressLine(0) + ", " + address.getLocality();
            }
        } catch (IOException e) {
            String exception = String.format("IOException!!");
            toast = Toast.makeText(getApplicationContext(), exception, Toast.LENGTH_LONG);
        } finally {

            if (result != null) {
                toast = Toast.makeText(getApplicationContext(), result, Toast.LENGTH_LONG);
            } else 
                toast = Toast.makeText(getApplicationContext(), "nix is", Toast.LENGTH_LONG);
        }




        final Intent intent = new Intent();
        setResult(RESULT_OK, intent);
        finish();
        return;
    }


    @Override
    public void onClick(View v) {
        getAddress();
        toast.show();
    }
});