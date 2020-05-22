vertx.fileSystem().open(fileName, new OpenOptions().setAppend(true), ar -> {
  if (ar.succeeded()) {
    AsyncFile writestream = ar.result();
    // If you write here it will be at the end of the file
  }
});