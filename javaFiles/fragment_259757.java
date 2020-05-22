public void onButtonClicked(View view) {
    // if we don't need to keep previewing new frames, stop the preview
    mCameraManager.stopPreview();
    // now, show our ImageView (which should be in front of the TextureView)
    Bitmap myBitmap = BitmapFactory.decodeFile(file_path_here);
    myImageView.setImageBitmap(myBitmap);
    myImageView.setVisibility(View.VISIBLE);
}