final Semaphore semaphore = new Semaphore(0);
final AtomicBoolean succeeded = new AtomicBoolean();

MyRestClient.post(possibleEmail, device, results, new AsyncHttpResponseHandler() {

    @Override
    public void onSuccess(int arg0, Header[] arg1, byte[] arg2) {
        succeeded.set(true);
        semaphore.release();
    }

    @Override
    public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
        succeeded.set(false);
        semaphore.release();
    }
});

semaphore.aquire();
return succeeded.get();