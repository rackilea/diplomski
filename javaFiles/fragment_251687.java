public abstract class RetrofitRequest<RESULT> extends SpiceRequest<Response<RESULT>> {

    protected RetrofitRequest(){
        super((Class<Response<RESULT>>) (Class<?>) Response.class);
    }

    @Override
    public final Response<RESULT> loadDataFromNetwork() throws Exception {
        WebService webService = RestFulWebService.getRestFulWebService();
        return doInBackground(webService);
    }

    @WorkerThread
    protected abstract Response<RESULT> doInBackground(WebService webService) throws Exception;

}