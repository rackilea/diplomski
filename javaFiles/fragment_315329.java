Handler handler = new Handler();
handler.postDelayed(new Runnable()
{
  @Override
  public void run() {
      if ( check.getStatus() == AsyncTask.Status.RUNNING )
          check.cancel(true);
  }
}, 10000 );