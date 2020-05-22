future = future.handle((t, ex) -> {
  if (ex != null) {
    logException(ex);
    return null;
  } else {
    return t;
  }
});