try{

        Bitmap bm = BitmapFactory.decodeResource(getResources(), R.drawable.shareforma);
        String extStorageDirectory = Environment.getExternalStorageDirectory().toString();
        File file = new File(extStorageDirectory, "forma.PNG");
        FileOutputStream outStream = new FileOutputStream(file);
        bm.compress(Bitmap.CompressFormat.PNG, 100, outStream);
        outStream.flush();
        outStream.close();
    }
    catch (IOException e) {
        e.printStackTrace();
    }
    String msgText = "Sample Message";

    Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
    shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
    shareIntent.setType("image/*");

    //set your message
    shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, msgText); 

    String imagePath = Environment.getExternalStorageDirectory() + File.separator + "image_name.jpg";

    File imageFileToShare = new File(imagePath);

    Uri uri = Uri.fromFile(imageFileToShare);

    shareIntent.putExtra(Intent.EXTRA_STREAM, uri);

    startActivity(Intent.createChooser(shareIntent, msgText));