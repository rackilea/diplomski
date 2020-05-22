vertx.fileSystem().open(fileToRead, new OpenOptions(), ar -> {
  if (ar.succeeded()) {
    AsyncFile readstream = ar.result();
    rs.setReadPos(offset);
  }
}