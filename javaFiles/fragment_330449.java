@RequiresApi(api = Build.VERSION_CODES.M)
@Override
protected void onActivityResult(int requestCode, int resultCode, final Intent data) {

    if (requestCode == cameraRequestCode) {
        if (resultCode == Activity.RESULT_OK) {

            FileOutputStream stream = null;

            try {

                Bitmap photo = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);

                String saveFilePath = getRealPathFromURI(imageUri);

                stream = new FileOutputStream(saveFilePath);
                photo.compress(Bitmap.CompressFormat.JPEG, 25, stream);

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Can't save image !", Toast.LENGTH_SHORT).show();
            } finally {
                try {
                    if (stream != null) {

                        stream.close();
                        Toast.makeText(getApplicationContext(), "Image saved successfully !", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(getApplicationContext(), "Can't save image, try again !", Toast.LENGTH_SHORT).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else if (resultCode == Activity.RESULT_CANCELED) {
            Toast.makeText(getApplicationContext(), "Cancelled", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Can't capture image !", Toast.LENGTH_SHORT).show();
        }

    }
}