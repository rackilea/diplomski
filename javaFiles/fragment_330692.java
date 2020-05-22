public void switchImage() {
    ImageView myImageView = (ImageView) findViewById(R.id.myImageView); 
    // TODO: get your image or color here and apply it to your single imageView
    // You may need an index while getting the next image or randomly get it.

    myImageView.setImageResource(getNextImageResId());
}