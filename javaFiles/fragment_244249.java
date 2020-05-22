File file =  new 
File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "readme.txt");
        FileOutputStream out = new FileOutputStream(file);
        out.write(wfile);
        out.flush();
        out.close();
        MediaScannerConnection.scanFile(mContext, new String[] { file.toString() }, null,new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
       });