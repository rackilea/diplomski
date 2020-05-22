protected void startLoading() {
    proDialog = new ProgressDialog(this);
    proDialog.setMessage("loading...");
    proDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
    proDialog.setCancelable(false);
    proDialog.show();
}

protected void stopLoading() {
    proDialog.dismiss();
    proDialog = null;
}