private Boolean isExporting = false;

public void exportFile(final Context mContext, boolean debug) {
    if (!isExporting) {
        isExporting = true;
        new AsyncTask<Void, String, Void>() {
            ProgressDialog progressDialog;

            @Override
            protected Void doInBackground(Void... arg0) {
                try {
                    // read data into byte array
                    final ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    int i = 0;
                    for (Integer r : recordsIdList) {
                        byte[] buffer = db.getRecord(r).toExportSQL().getBytes();
                        Log.i("test", new String(buffer));
                        baos.write(buffer);
                        publishProgress("Writing " + (i++) + " from " + totalLines);
                    }
                    baos.close();
                    // write data to file
                    final String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/DroidP";
                    final File dir = new File(path);
                    dir.mkdirs();
                    final File file = new File(dir, "Droid_export.txt");
                    file.createNewFile();
                    final FileOutputStream fos = new FileOutputStream(file);
                    fos.write(baos.toByteArray());
                    fos.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return null;
            }

            @Override
            protected void onProgressUpdate(String... progress) {
                progressDialog.setMessage(progress[0]);
            }

            @Override
            protected void onPostExecute(Void result) {
                super.onPostExecute(result);
                isExporting = false;
                progressDialog.dismiss();
            }

            @Override
            protected void onPreExecute() {
                progressDialog = ProgressDialog.show(mContext,
                        "Exporting file", "", true);
            }
        }.execute();
    }
}