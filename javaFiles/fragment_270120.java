public void addToFav(String dirName, String str) {

    String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
    String fileName = "fav" + timeStamp + ".JPG";


    File direct = new File(Environment.getExternalStorageDirectory() + dirName);

    if (!direct.exists()) {
        File wallpaperDirectory = new File(Environment.getExternalStorageDirectory() + dirName);
        wallpaperDirectory.mkdirs();
    }

    File file = new File(new File(Environment.getExternalStorageDirectory() + dirName), fileName);
    if (file.exists()) {
        file.delete();
    }
    try {
        FileOutputStream out = new FileOutputStream(file);

        Bitmap bitmap = BitmapFactory.decodeFile(imagesPathArrayList.get(pos));
        bitmap.compress(Bitmap.CompressFormat.JPEG, 20, out);
        out.flush();
        out.close();
    } catch (Exception e) {
        e.printStackTrace();
    }

    ContentValues values = new ContentValues();
    values.put(Images.Media.TITLE, "title");
    values.put(Images.Media.DESCRIPTION, "description");
    values.put(Images.Media.DATE_TAKEN, System.currentTimeMillis());
    values.put(Images.ImageColumns.BUCKET_ID, file.toString().toLowerCase(Locale.US).hashCode());
    values.put(Images.ImageColumns.BUCKET_DISPLAY_NAME, file.getName().toLowerCase(Locale.US));
    values.put("_data", file.getAbsolutePath());
    ContentResolver cr = getContentResolver();
    cr.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);

  }