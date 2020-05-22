File file =  new 
 File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), "MY_IMAGE.PNG");

 FileOutputStream out = new FileOutputStream(file);
 b.compress(Bitmap.CompressFormat.PNG, 95, out);
            out.flush();
            out.close();
MediaScannerConnection.scanFile(mContext, new String[] { file.toString() }, null,new MediaScannerConnection.OnScanCompletedListener() {
            public void onScanCompleted(String path, Uri uri) {
                Log.i("ExternalStorage", "Scanned " + path + ":");
                Log.i("ExternalStorage", "-> uri=" + uri);
            }
       });