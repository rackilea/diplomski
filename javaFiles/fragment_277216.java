@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == Thing.SPECIFIC_REQUEST_CODE) {
            Thing.ActivityResult result = Thing.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                Uri resultUri = result.getUri();
                imageURI = resultUri.toString();    
            }
       }