Channel channel = ....;
SynchronousQueue<Promise<String>> queue = ....;

public Future<String> sendCommandAsync(String command) {
    return sendCommandAsync(command, new DefaultPromise<>());
}

public Future<String> sendCommandAsync(String command, Promise<String> promise) {
    synchronized(channel) {
        queue.offer(promise);
        channel.write(command);
    }
    channel.flush();
}