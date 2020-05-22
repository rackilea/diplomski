runOnUiThread(new Runnable() {
  @Override
  public void run() {
     mAdapter.notifyDataSetChanged();
  }
});