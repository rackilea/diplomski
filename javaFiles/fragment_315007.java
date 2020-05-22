asynCtx.addListener(new AsyncListener()
{
  @Override
  public void onComplete(AsyncEvent asyncEvent) throws IOException
  {
    System.out.println("onComplete(...)");
  }

  @Override
  public void onTimeout(AsyncEvent asyncEvent) throws IOException
  {
    // this will close the request and the context gracefully
    // and the net:ERR is gone.
    asyncEvent.getAsyncContext().complete();
    System.out.println("onTimeout(...)");
  }

  @Override
  public void onError(AsyncEvent asyncEvent) throws IOException
  {
    System.out.println("onError(...)");
  }

  @Override
  public void onStartAsync(AsyncEvent asyncEvent) throws IOException
  {
    System.out.println("onStart(...)");
  }
});