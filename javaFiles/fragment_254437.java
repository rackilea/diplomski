public void foo() throws IOException {
  try (InputStream in = openInputStream();
       OutputStream out = openOutputStream();
    // do stuff with in and out
  }
}