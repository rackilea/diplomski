@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

if (requestCode == 1) {
    if(resultCode == Activity.RESULT_OK){
        String result=data.getStringExtra("result");
    }
    if (resultCode == Activity.RESULT_CANCELED) {
        //Write your code if there's no result
    }
}
}//onActivityResult