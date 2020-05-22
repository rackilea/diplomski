public void setPositionToView (Context ctx, List addresses,View mainview) { try {

    String street = addresses.get(0).getAddressLine(0);
    String city = addresses.get(0).getAddressLine(1);
    String country = addresses.get(0).getAddressLine(2);

    Log.i(AppHelper.APP_LOG_NAMESPACE, street);

    // display toast message with success state
    Toast.makeText(ctx, "TEST", Toast.LENGTH_LONG).show();

    // change state text to success and colorize text green
    TextView eanTv = (TextView) mainview.findViewById(R.id.street);
    eanTv.setText("Test");
    //stateTv.setTextColor(getResources().getColor(R.color.green));

} catch (Exception e) {
    Log.e(AppHelper.APP_LOG_NAMESPACE, "getAndSavePosition method cannot be processed", e);
    e.printStackTrace();
}