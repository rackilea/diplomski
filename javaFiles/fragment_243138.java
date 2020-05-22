@Override
protected void onStop() {
    super.onStop();
    if (dialog!=null) {
        if (dialog.isShowing()) {
            dialog.dismiss();       
        }
    }
}