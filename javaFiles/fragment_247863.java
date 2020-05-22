@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // TODO Auto-generated method stub
    //super.onActivityResult(requestCode, resultCode, data);
    if (resultCode == RESULT_CANCELED){
        Toast.makeText(getApplicationContext(), "too bad..", Toast.LENGTH_LONG).show();
        finish();
    }
    else if (resultCode == RESULT_OK)
    {
         GetPairedDevices();
    }