@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == request_code) {
        if(resultCode == Activity.RESULT_OK){
            String value=data.getStringExtra("value");
            String cost=data.getStringExtra("cost");
            //handle value and cost.
        }
    }
}