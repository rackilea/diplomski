protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK ){
       //setting Activity.RESULT_OK  


            ArrayList<String> selectedItems = data.getStringArrayListExtra("selectedItems");