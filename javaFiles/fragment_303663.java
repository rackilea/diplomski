public void onProgressChanged(WebView view, int progress) {
  if( progressDialog.isShowing() ) {
    progressDialog.setProgress(0);
    getActivity().setProgress(progress * 1000);

    progressDialog.incrementProgressBy(progress);

    if ( progress == 100 )
      progressDialog.dismiss();
  }
}