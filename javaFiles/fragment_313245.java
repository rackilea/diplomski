try {
        String folder = "myfiles";
        names=am.list(folder);
        InputStream is= am.open(folder+"/"+names[0]);
        bmp =BitmapFactory.decodeStream(is);
        img.setImageBitmap(bmp);
    }