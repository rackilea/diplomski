String imgPath = rep.getImgList().get(0);
    File file = new File(imgPath);
    AtomicFile atomicFile =  new AtomicFile(file);
    FileOutputStream fos = null;
    try {
        // read the current image
        Bitmap bitmap = BitmapFactory.decodeFile(file.getAbsolutePath());
        // open the stream (backup the current content)
        // from now on (and until finishWrite/failWrite) we cannot read the file directly
        fos = atomicFile.startWrite();
        Log.d("showmethebitmap", bitmap.toString()); //Error: bitmap is null !
        OutputStream oos = new BufferedOutputStream(fos);
        bitmap.compress(Bitmap.CompressFormat.JPEG,0,oos);
        // flush but do not close the stream (@see AtomicFile doc)
        oos.flush();
        // close the stream, remove the backup
        atomicFile.finishWrite(fos);
        ...
    } catch (IOException e) {
        // recover the content from the backup
        atomicFile.failWrite(fos);
        throw e;
    }