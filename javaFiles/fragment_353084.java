@Override
protected void onPreExecute() {
    progressDialog = new ProgressDialog(activity);
    progressDialog.setTitle("Downloading");
    progressDialog.setMessage("Downloaded 0/" + urls.size());
    progressDialog.setIndeterminate(false);
    progressDialog.setProgress(0);
    progressDialog.setMax(urls.size());
    progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
    progressDialog.show();
}