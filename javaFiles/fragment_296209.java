protected  void onImageViewClick(){
  //  ImageView imageView=(ImageView)findViewById(R.id.imageView2);
    TextView tw=(TextView)findViewById(R.id.addimage);
    tw.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectImage();
        }
    });

}


private void selectImage() {
    Intent takeImageIntent = ImagePicker.getPickImageIntent(this);
    if (takeImageIntent.resolveActivity(getActivity().getPackageManager()) != null) {
        startActivityForResult(takeImageIntent, REQUEST_IMAGE_CAPTURE);
    }
}