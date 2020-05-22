@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    if (requestCode == a_unique_integer_code) {
        if(resultCode == Activity.RESULT_OK){
            millisSecond = data.getInt("millisSecond");
        }
        if (resultCode == Activity.RESULT_CANCELED) {
           //if there exists an event where the variable is not set you can do something about it here
        }
    }
}