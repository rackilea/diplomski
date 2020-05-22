public void onActivityResult(int requestCode, int resultCode, Intent data) {
 if (requestCode == TAKE_PICTURE && resultCode == RESULT_OK) {

 try {
 GetImageThumbnail getImageThumbnail = new GetImageThumbnail();
 Bitmap bitmap = getImageThumbnail.getThumbnail(fileUri, this);
 myMarkersHash.put(markerId, bitmap );
 } catch (FileNotFoundException e1) {
    e1.printStackTrace();
    } catch (IOException e1) {
      e1.printStackTrace();
        }