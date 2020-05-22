@Override
public void onProgressChanged(SeekBar seekBar, int progress,
        boolean fromUser) {
    int lower = Color.argb(0xFF, progress, progress, progress);
    sharp = Bitmap.createBitmap(back); // create a copy

    ManipBitmap.sharpen(sharp,lower);
    image.setImageBitmap(sharp);
}