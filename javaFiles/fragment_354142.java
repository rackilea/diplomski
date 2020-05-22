public class HttpAsyncTaskLoader<T extends ApiResponse> extends AsyncTaskLoader {
    private ApiClient mClient ;
    protected ApiRequest mRequest;
    private ApiResponse mResponse;
    private volatile boolean isExecuting = false;
    public HttpAsyncTaskLoader(Context context, ApiClient client, ApiRequest request) {
        super(context);
        mClient = client;
        mRequest = request;
    }

    /** Subclasses should call this from loadInBackground   */
    protected ApiResponse executeRequest(ApiRequest request) {
        HttpResponse response = null;
        ResponseError error = null;
        JSONObject responseJson = null;
        try {
            isExecuting = true;
            Log.d(TAG, "executing api");
            response  =  mClient.execute(request);
            Log.d(TAG, "got a response");
            isExecuting = false;
            responseJson = new JSONObject(EntityUtils.toString(response.getEntity()));
            Log.d(TAG, "parsed response to json");
        } catch (IOException e) {
            error = new ResponseError(e);
        } catch (URISyntaxException e) {
            error = new ResponseError(e);
        } catch (JSONException e) {
            error = new ResponseError(e);
        } finally {
            mClient.getConnectionManager().closeExpiredConnections();
            isExecuting = false;
            mResponse = new ApiResponse(getContext().getResources(), response, responseJson, error);
        }
        return mResponse;
    }

    protected void onStartLoading() {
        super.onStartLoading();
        if (takeContentChanged() ||  mResponse == null) {
            forceLoad();
        }
        if (getResponse() != null) {
            deliverResult(getResponse());
        }
    }

    /** 
    * Subclasses should also override this so the correct object 
    * gets delivered in all cases (see onStartLoading above)
    */
    public ApiResponse getResponse() {
        return mResponse;
    }

    @Override
    public void onCanceled(Object data) {
        super.onCanceled(data);
        if (isExecuting) {
            mClient.getConnectionManager().shutdown();
        }
    }

    @Override
    public ApiResponse loadInBackground() {
        return executeRequest(mRequest);
    }
}