@Implements(AsyncTask.class)
public class MyShadowAsyncTask<Params, Progress, Result> extends ShadowAsyncTask<Params, Progress, Result> {

  @RealObject private AsyncTask<Params, Progress, Result> realAsyncTask;

    @Implementation
    public AsyncTask<Params, Progress, Result> executeOnExecutor(Executor executor, Params... params) {
        return super.execute(params);
    }       
}