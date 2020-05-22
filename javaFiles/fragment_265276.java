BitmapFactory.Options options = new BitmapFactory.Options(); 
options.outMimeType = "image/jpeg";

Bitmap bitmap= BitmapFactory.decodeResource(getResources(),
        R.mipmap.ic_launcher, options);

String path = MediaStore.Images.Media.insertImage(getContentResolver(), bitmap, "Image Description", null);
Uri uri = Uri.parse(path);

Intent intent = new Intent(Intent.ACTION_SEND);
intent.setType("image/jpeg");
intent.putExtra(Intent.EXTRA_STREAM, uri);
startActivity(Intent.createChooser(intent, "Share Image"));