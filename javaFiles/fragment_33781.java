for (;;) {
  //wait for key to be signaled
  WatchKey key;
  try {
    key = watcher.take();
  } catch (InterruptedException x) {
    return;
  }

for (WatchEvent<?> event: key.pollEvents()) {
  WatchEvent.Kind<?> kind = event.kind();
  if (kind == OVERFLOW) {
      continue;
  }
...
}