private void displayImage(String imageFilename) {
    // dynamically create an image and add it to the image container layout
    RelativeLayout container = findViewById(R.id.imageContainer);
    ImageView img = new ImageView(this);

    // image should be loaded from the given filename - for now use a solid background and fixed height
    img.setBackgroundColor(Color.BLUE);
    RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(
            RelativeLayout.LayoutParams.MATCH_PARENT, 500);
    container.addView(img, params);
    Picasso.with(this).load(imageFilename).into(img);

    adjustScrolling(container);
}