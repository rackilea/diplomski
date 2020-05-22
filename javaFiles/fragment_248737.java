vertx.fileSystem().open(path, new OpenOptions().setAppend(true), ar -> {
  if (ar.succeeded()) {
    AsyncFile ws = ar.result();
    list.forEach(str -> {
      Buffer chunk = Buffer.buffer(str);
      ws.write(chunk);
    });
  } else {
    System.err.println("Could not open file");
  }
});