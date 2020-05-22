channel.writeAndFlush(...).addListener(new GenericFutureListener<Future<Object>>() {
    @Override
    public void operationComplete(Future<Object> future) {
        // TODO: Use proper logger in production here
        if (future.isSuccess()) {
            System.out.println("Data written succesfully");
        } else {
            System.out.println("Data failed to write:");
            future.cause().printStackTrace();
        }
    }
});