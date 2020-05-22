Bitmap cameraImage;

@Override
public void onViewStateRestored(Bundle savedInstanceState) {
    super.onViewStateRestored(savedInstanceState);

    if (cameraImage != null) {
        mImageView.setImageBitmap(cameraImage);
    }
}

@Override
public void onImageSaved(byte[] data) {
    if (data != null) {
        Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
        cameraImage = bitmap;
    }
} else {
    Log.v(TAG, "Didn't get any result");
}