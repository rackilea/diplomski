@Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == PICK_IMAGE && resultCode == RESULT_OK && data.getClipData() != null) {
            int count = data.getClipData().getItemCount();
            for(int i = 0; i < count; i++) {
                Uri screen = data.getClipData().getItemAt(i).getUri();
                imgUri1 = data.getClipData().getItemAt(0).getUri();
                imgOne.setImageURI(imgUri1);
                imgUri2 = data.getClipData().getItemAt(1).getUri();
                imgTwo.setImageURI(imgUri2);
            }
        }
    }