public void DownloadFile(String fileURL, String fileName) {
    try {
        String RootDir = Environment.getExternalStorageDirectory()
                + File.separator + "Cards List";
        File RootFile = new File(RootDir);
        RootFile.mkdir();
        // File root = Environment.getExternalStorageDirectory();
        java.net.URL u = new URL(fileURL);
        HttpURLConnection c = (HttpURLConnection) u.openConnection();
        c.setRequestMethod("GET");
        c.setDoOutput(true);
        c.connect();
        FileOutputStream f = new FileOutputStream(new File(RootFile,
                fileName + " abc " + ".pdf"));
        InputStream in = c.getInputStream();
        byte[] buffer = new byte[1024];
        int len1 = 0;

        while ((len1 = in.read(buffer)) > 0) {
            f.write(buffer, 0, len1);
        }
        f.close();


    } catch (Exception e) {

        Log.d("Error....", e.toString());
    }

} // used to download the file from server

class ProgressBack extends AsyncTask<String, Void, Void> {
    ProgressDialog PD;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        PD = ProgressDialog.show(MainActivity.this, null, "Please Wait ...", true);
        PD.setCancelable(true);
    }

    @Override
    protected Void doInBackground(String... params) {
        DownloadFile("https://scholar.najah.edu/sites/default/files/book/dllt-lhwy-wlrmz-fy-lfwlklwr-lshby.pdf",
                "Cards List"); // calling DownloadFile
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        PD.dismiss();
        Toast.makeText(MainActivity.this, "Download Completed", Toast.LENGTH_SHORT).show();
    }
}