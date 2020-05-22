File imgFile;
       String path = Environment.getExternalStorageDirectory() + "/AppName/" + ".jpg";
        imgFile = new File(path);

        if (imgFile.exists()) {
            Bitmap bitmap = BitmapFactory.decodeFile(imgFile.getAbsolutePath());
            imageView.setImageBitmap(bitmap);
        }