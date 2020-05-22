CountDownLatch done = new CountDownLatch(1);
tileProvider.getTile(x, y, zoom, new GetDataListener<byte[]>() {
    @Override
    public void onGetData(byte[] data, Exception exception) {
        tileRequest.data = data;
        tileRequest.exceptionOccurred = exception != null;
        tileRequest.finishedRequest = true;
        done.countDown();
    }
});

done.await();
return tileRequest.getTile();