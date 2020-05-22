static class DownloadFile extends AsyncTask<String, Integer, String> { // Quelle: https://www.androidhive.info/2012/04/android-downloading-file-by-showing-progress-bar/

        @Override
        public String doInBackground(String... sUrl) {
            try {
                URL url = new URL(sUrl[0]);
                URLConnection connection = url.openConnection();
                connection.connect();
                int fileLength = connection.getContentLength();
                InputStream input = new BufferedInputStream(url.openStream());
                OutputStream output = new FileOutputStream(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + "Test.jpg");
                byte data[] = new byte[8192];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    total += count;
                    publishProgress((int) (total * 100 / fileLength));
                    output.write(data, 0, count);
                }
                System.out.println("Download beendet!");
                output.flush();
                output.close();
                input.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            return null;
        }
// ---- comment this        
//    }

        @Override
        protected void onProgressUpdate(Integer... progress) {
            progressBar.setProgress(progress[0]);
            setProgressText(progress[0]);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(this, "Download beendet!", Toast.LENGTH_LONG).show();
        }
//----- Add extra } here        
    }