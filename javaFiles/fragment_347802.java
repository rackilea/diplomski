public void onClick(View v) {
    switch (v.getId()) {

            case R.id.Btn1:
                doSomething();
                break;
            case R.id.Btn2:
                doSomething();
                break;
        }
    }

public void doSomething(){
    Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
    photoPickerIntent.setType("image/*");
    startActivityForResult(photoPickerIntent, 1); //Gallery acessing
}


@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);

    if (resultCode == RESULT_OK) {
        super.setContentView(R.layout.activity_view);
        selectedImage = (ImageView) findViewById(R.id.selectedImage); //Onresult redarct to anothr activity
    }
    Uri photoUri = data.getData();
    if (photoUri != null) {
        try {
            currentImage = MediaStore.Images.Media.getBitmap(this.getContentResolver(), photoUri);
            selectedImage.setImageBitmap(currentImage);

        } catch (Exception e) {
            e.printStackTrace();

            Intent myIntent = new Intent(this, ViewActivity.class);
            startActivity(myIntent); //switch activity
             }
    }}

    }