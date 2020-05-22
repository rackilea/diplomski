... your code

  @Override
  public void onActivityResult(int reqCode, int resCode, Intent data) {
    if(reqCode == REQ_TAKE_PICTURE) {
     String uriExtra = data.getStringExtra(TakePictureActivity.RESULT_IMAGE_URI);
     int positionExtra = data.getIntExtra("PhotoParentPosition")
updateImageItem(Uri.parse(uriExtra), positionExtra)
    }
  }

... your code

private void startTakePhoto(int position) {
    // saving state which is better to avoid
    tempItemPosition = position;
    Intent intent = new Intent(this, TakePhotoActivity.class);
    intent.putExtra("PhotoParentPosition", position);
    startActivityForResult(intent, REQ_TAKE_PICTURE);
  }