@Override
public void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (resultCode == RESULT_OK && requestCode == 1 && null != data) {
        decodeUri(data.getData());
    }
}

public void decodeUri(Uri uri) {
    ParcelFileDescriptor parcelFD = null;
    try {
        parcelFD = getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor imageSource = parcelFD.getFileDescriptor();

        // Decode image size
        BitmapFactory.Options o = new BitmapFactory.Options();
        o.inJustDecodeBounds = true;
        BitmapFactory.decodeFileDescriptor(imageSource, null, o);

        // the new size we want to scale to
        final int REQUIRED_SIZE = 1024;

        // Find the correct scale value. It should be the power of 2.
        int width_tmp = o.outWidth, height_tmp = o.outHeight;
        int scale = 1;
        while (true) {
            if (width_tmp < REQUIRED_SIZE && height_tmp < REQUIRED_SIZE) {
                break;
            }
            width_tmp /= 2;
            height_tmp /= 2;
            scale *= 2;
        }

        // decode with inSampleSize
        BitmapFactory.Options o2 = new BitmapFactory.Options();
        o2.inSampleSize = scale;
        Bitmap bitmap = BitmapFactory.decodeFileDescriptor(imageSource, null, o2);

        imageview.setImageBitmap(bitmap);

    } catch (FileNotFoundException e) {
        // handle errors
    } catch (IOException e) {
        // handle errors
    } finally {
        if (parcelFD != null)
            try {
                parcelFD.close();
            } catch (IOException e) {
                // ignored
            }
    }
}