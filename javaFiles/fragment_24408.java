class CallbackTask<T>
  implements Callable<T>
{

  private final Callable<? extends T> task;

  private final Callback<T> callback;

  CallbackTask(Callable<? extends T> task, Callback<T> callback)
  {
    this.task = task;
    this.callback = callback;
  }

  public T call()
    throws Exception
  {
    try {
      T result = task.call();
      callback.complete(result);
      return result;
    }
    catch (Exception ex) {
      callback.failed(ex);
      throw ex;
    }
  }

}