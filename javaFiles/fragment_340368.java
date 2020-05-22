private boolean findPrinter(final Context ctx) {
    final CountdownLatch latch = new CountdownLatch(1);
    final boolean[] result = {false};

    ...

    BluetoothDiscoverer.findPrinters(ctx, new DiscoveryHandler() {

        ...

        public void discoveryFinished() {
            result[0] = true;
            latch.countDown();
        }

        public void discoveryError(String arg0) {
            result[0] = false;
            latch.countDown();
        }

        ...
    }

    // before final return
    // wait for 10 seconds for the response
    latch.await(10, TimeUnit.SECONDS);

    //return the result, it will return false when there is timeout
    return result[0];
}