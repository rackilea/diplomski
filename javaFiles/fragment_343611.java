@Override    
protected void onActivityResult(int requestCode, int resultCode, Intent data){

    if (requestCode == REQUEST_CODE_PLACEPICKER && resultCode == RESULT_OK){

        displayplace(data);
    }
}