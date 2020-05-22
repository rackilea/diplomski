final ChannelFuture f = b.connect("0.0.0.0", 8080);
    f.addListener(new FutureListener<Void>() {

        @Override
        public void operationComplete(Future<Void> future) throws Exception {
            if (!f.isSuccess()) {
                System.out.println("Test Connection failed");
                handleException(future.cause());

            }
        }
    });
    //f.sync();