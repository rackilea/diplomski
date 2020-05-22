try {
    InputStream ims = getAssets().open(""+your_image_name);
    Drawable d = Drawable.createFromStream(ims, null);
    mImage.setImageDrawable(d);
    ims.close();
} catch(IOException ex) {
    return;
}