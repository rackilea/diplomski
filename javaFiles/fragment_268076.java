final String drv = (EditText)findViewById(R.id.drv_in)).getText().toString();
if(drv.equals("") {
    TX_FAIL_TEXT = "Missing Driver ID!";
    Log.e("SMSDRVERR", "Missing ID " + drv);
}
else {
    Log.e("SMSDRVERR", "Found ID" + drv);
}