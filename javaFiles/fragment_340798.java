@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    super.onActivityResult(requestCode, resultCode, data);
    if (listener != null) {
        listener.onActivityResult(requestCode, resultCode, data);
    }
}