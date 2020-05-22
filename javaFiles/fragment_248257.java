private ImageButton myImageButton;

//Code....

public void onSaveInstanceState(Bundle b){
    super.onSaveInstanceState(b);//THIS IS VERY IMPORTANT
    b.putInt("image_1", idofyourimage); //This is where you store the id of the image
    //you can store all sorts of data in the bundle, so use whatever works
    //for you.
}



public void onRestoreInstanceState(Bundle b){
    super.onRestoreInstanceState(b);//IMPORTANT
    int imageId = b.getInt("image_1");
    myImageButton = new ImageButton();
    myImageButton.setImageResource(imageId);
    //Any other stuff you need to do
}