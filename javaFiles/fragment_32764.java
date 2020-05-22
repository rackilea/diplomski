Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
intent.setType("image/*"); //allows any image file type. Change * to specific extension to limit it
//**These following line is the important one!
intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURES); //SELECT_PICTURES is simply a global int used to check the calling intent in onActivityResult

@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if(requestCode == SELECT_PICTURES) {
        if(resultCode == Activity.RESULT_OK) {
            if(data.getClipData() != null) {
                int count = data.getClipData().getItemCount();
                int currentItem = 0;
                while(currentItem < count) {
                    Uri imageUri = data.getClipData().getItemAt(currentItem).getUri();
                    //do something with the image (save it to some directory or whatever you need to do with it here)
                    currentItem = currentItem + 1;
                }
            } else if(data.getData() != null) {
                String imagePath = data.getData().getPath();
                //do something with the image (save it to some directory or whatever you need to do with it here)
            }
        }
    }
}