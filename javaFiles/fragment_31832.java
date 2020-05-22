@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    // Check which request we're responding to
    if (requestCode == REQUEST_CODE_COlLOR1) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
            //Set your color on your first button
           yourColor =  data.getExtras().get("color1");
        }

    }
    if (requestCode == REQUEST_CODE_COlLOR2) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
            //Set your color on your second button
           yourColor2 =  data.getExtras().get("color2");
        }

    }
    if (requestCode == REQUEST_CODE_COlLOR3) {
        // Make sure the request was successful
        if (resultCode == RESULT_OK) {
            //Set your color on your mixed color button
            yourColor3 =  data.getExtras().get("color3");
        }

    }
}