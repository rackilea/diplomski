b = (Button)findViewById(R.id.btnSelectPhoto);
//viewImage = (ImageView)findViewById(R.id.viewImage);
b.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        selectImage();
    }
});