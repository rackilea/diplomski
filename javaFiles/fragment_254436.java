public void foo() throws IOException {
  Closer closer = Closer.create();
  try {
    InputStream in = closer.register(openInputStream());
    OutputStream out = closer.register(openOutputStream());
    // do stuff with in and out
  } catch (Throwable e) { // must catch Throwable
    throw closer.rethrow(e);
  } finally {
    closer.close();
  }
}