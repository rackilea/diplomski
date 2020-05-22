@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == 1) {
        if(resultCode == Activity.RESULT_OK){

            Person myObject = (Person) data.getParcelableExtra("result");
        }
        if (resultCode == Activity.RESULT_CANCELED) {
        }
    }
}