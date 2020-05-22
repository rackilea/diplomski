public void clickedImage(View view) {
    ImageView image = (ImageView) view;
    Bitmap clicked = drawableToBitmap(image.getDrawable());
    Bitmap displayed = drawableToBitmap(imageView.getBackground());
    if (clicked == displayed) {
        textView.setText("Well Done!");
    } else {
        textView.setText("Unlucky!");
    }
}

public Bitmap drawableToBitmap(Drawable d) {
    Bitmap b = Bitmap.createBitmap(d.getIntrinsicWidth(), d.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
    Canvas c = new Canvas(b);
    d.setBounds(0, 0, c.getWidth(), c.getHeight());
    d.draw(c);
    return b;
}