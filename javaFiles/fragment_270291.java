@Override
public Object instantiateItem(ViewGroup container, int position) {
    View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);

    imageView = (ImageView) itemView.findViewById(R.id.imageView);

  imagepostion=position;
  imageView.setImageResource(mResources[position]);

  imageView.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
//save image to device
      saveImage();
//share image code
      shareImageFromDevice();
    }
    });
    container.addView(itemView);

    return itemView;
}

private void saveImage(){

Bitmap bitmap = BitmapFactory.decodeResource(getResources(),mResources[position]);

File image = new File(getExternalFilesDir(null), "test.png");
// After that, you just have to write the Bitmap thanks to its method compress such as:

boolean success = false;

// Encode the file as a PNG image.
FileOutputStream outStream;
try {

    outStream = new FileOutputStream(image);
    bitmap.compress(Bitmap.CompressFormat.PNG, 100, outStream);
    /* 100 to keep full quality of the image */

    outStream.flush();
    outStream.close();
    success = true;
} catch (IOException e) {
    e.printStackTrace();
}
//Finally, just deal with the boolean result if needed. Such as:

if (success) {
    Toast.makeText(getApplicationContext(), "Image saved with success",
            Toast.LENGTH_LONG).show();
} else {
    Toast.makeText(getApplicationContext(),
            "Error during image saving", Toast.LENGTH_LONG).show();
}
}
    private void shareImageFromDevice(){

    File file = new File(getExternalFilesDir(null), "test.png");

    Uri uri=Uri.fromFile(file);

    Intent share = new Intent(Intent.ACTION_SEND);
    share.setType("image/*");
    share.putExtra(Intent.EXTRA_STREAM, uri);
    startActivity(Intent.createChooser(share, "Share Image"));
}