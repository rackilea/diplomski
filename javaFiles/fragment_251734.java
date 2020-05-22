public interface Callback {
  void call(MessageAndMetadata message);
}

Executor executor = Executors.newCachedThreadPool();
final Callback<byte[], byte[]> callback = new MyCallback();
while (it.hasNext()) {
  final MessageAndMetadata message = it.next();
  executor.submit(new Runnable() {
    public void run() {
      callback.call(message);
    }
  });
}