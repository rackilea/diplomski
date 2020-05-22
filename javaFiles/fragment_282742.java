static void invokeChannelInactive(final AbstractChannelHandlerContext next) {
    EventExecutor executor = next.executor();
    if (executor.inEventLoop()) {
        next.invokeChannelInactive();
    } else {
        executor.execute(new Runnable() {
            @Override
            public void run() {
                next.invokeChannelInactive();
            }
        });
    }
}