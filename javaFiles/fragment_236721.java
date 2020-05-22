class DownloadImagesAsync extends AsyncTask<String, String, String> {
private int id = 0;
private    MyCallback callback;
            Boolean isSDPresent = android.os.Environment.getExternalStorageState().equals(android.os.Environment.MEDIA_MOUNTED);

            private String resp;
            int lengthOfFile;
    public DownloadImagesAsync(int id, MyCallback callback) {
this.id = id;
this.callback = callback;
}
            @Override
            protected String doInBackground(String... params) {


                int count;

                try {
                    URL url = new URL(params[0]);
                    URLConnection connection = url.openConnection();
                    connection.connect();

                    lengthOfFile = connection.getContentLength();
                    Log.d("ANDRO_ASYNC", "LENGTH OF FILE : " + lengthOfFile);

                    String fileName = params[0].substring(params[0].lastIndexOf('/') + 1, params[0].length());
                    Log.d("FILENAME", fileName);
                    resp = fileName;

                    if (isSDPresent) {

                        InputStream inputStream = new BufferedInputStream(url.openStream());
                        OutputStream outputStream = new FileOutputStream("sdcard/rreadyreckoner_images/" + fileName);
                        byte data[] = new byte[1024];
                        long total = 0;
                        while ((count = inputStream.read(data)) != -1) {
                            total += count;
                            outputStream.write(data, 0, count);
                        }

                        outputStream.flush();
                        outputStream.close();
                        inputStream.close();
                    } else {
                        InputStream inputStream = new BufferedInputStream(url.openStream());
                        OutputStream outputStream = new FileOutputStream(getFilesDir() + "/rreadyreckoner_images/" + fileName);
                        byte data[] = new byte[1024];
                        long total = 0;
                        while ((count = inputStream.read(data)) != -1) {
                            total += count;
                            outputStream.write(data, 0, count);
                        }

                        outputStream.flush();
                        outputStream.close();
                        inputStream.close();

                    }


                } catch (Exception e) {
                    e.printStackTrace();
                }
                return params[0];
            }

            @Override
            protected void onPostExecute(String filename) {
                Log.d("PARAM", filename + " Downloaded ");
    if (callback != null) {
callback.readycallback(myid);
}
                String fname = filename.substring(filename.lastIndexOf('/') + 1, filename.length());

                Log.d("LENGTH OF FILE : ", String.valueOf(lengthOfFile));

                if (isSDPresent) {

                    File f = new File("/storage/emulated/0/rreadyreckoner_images/" + fname);
                    if (f.length() < lengthOfFile) {
                        if (f.delete()) {

                            //  Toast.makeText(RReadySplash.this, "Download was interrupted please try again!", Toast.LENGTH_SHORT).show();
                            Log.d("Del", "File deleted");
                        } else {

                            Log.d("NOTDel", "File not deleted");
                        }
                    } else {

                        // dbHandler.updateDownloadStatus(image_id, "YES");

                    }

                } else {

                    File f = new File("/storage/emulated/0/rreadyreckoner_images/" + fname);
                    if (f.length() < lengthOfFile) {
                        if (f.delete()) {

                            Log.d("Del", "File deleted");
                        } else {

                            Log.d("NOTDel", "File not deleted");
                        }
                    } else {

    //                    dbHandler.updateDownloadStatus(image_id, "YES");


                    }


                }


            }

            @Override
            protected void onPreExecute() {
                super.onPreExecute();

            }

            @Override
            protected void onProgressUpdate(String... values) {
                Log.d("ANDRO_ASYNC", values[0]);

            }
        }