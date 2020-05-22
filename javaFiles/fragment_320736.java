// Note: declare ProgressDialog progress as a field in your class.

progress = ProgressDialog.show(this, "dialog title",
  "dialog message", true);

new Thread(new Runnable() {
  @Override
  public void run()
  {
    // do the thing that takes a long time

    runOnUiThread(new Runnable() {
      @Override
      public void run()
      {
        progress.dismiss();
      }
    });
  }
}).start();