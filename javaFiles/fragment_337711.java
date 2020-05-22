protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if(requestCode == 1) {
        if (resultCode == RESULT_OK) {


            String result1 = data.getStringExtra("result1"); 
            String result2 = data.getStringExtra("result2");
            String result3 = data.getStringExtra("result3");

            //Update the database with new data
        }

        if (resultCode == RESULT_CANCELED) {
            //No change
        }
    }
}//onActivityResult