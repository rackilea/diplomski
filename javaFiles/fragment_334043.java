@Override
public void handleMessage(Message msg) {
    int currentImage = 0;
    int nextImage = 0;
    // Logic to change the images
    for (ImageView imageView : imageHolders) {
        currentImage = Integer.parseInt(imageView.getTag().toString());
        if (currentImage < 9) {
            nextImage = currentImage + 1;
        } else {
            nextImage = 1;
        }
        imageView.setTag("" + nextImage);
        imageView.setImageResource(getResources().getIdentifier(
                images.get(nextImage - 1), "drawable",
                "com.beanie.example"));
    }
    super.handleMessage(msg);
}