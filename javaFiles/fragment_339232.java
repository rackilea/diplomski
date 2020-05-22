@Override
protected void onResume() {
    super.onResume();
    image1 = onUpdate();
}

private ImageView onUpdate() {
    ImageView image = new ImageView(this); // I would like to override member variable image1
    // update image parameters
    return image;
}