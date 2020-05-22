@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
     super.onActivityResult(requestCode, resultCode, data);
     switch (requestCode) {
     case TAKE_PICTURE:
         if (resultCode == Activity.RESULT_OK) {
             Uri selectedImage = imageUri;
             getContentResolver().notifyChange(selectedImage, null);
             Bitmap bitmap;
             try {
                  bitmap = android.provider.MediaStore.Images.Media
                  .getBitmap(getContentResolver(), selectedImage);

                 // show image here in an imageView

                  } catch (Exception e) {
                 Log.e("Camera", e.toString());
             }
         }
     }
 }