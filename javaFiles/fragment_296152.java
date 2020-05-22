BufferedWriter f = null;
try {
  f = new BufferedWriter(...);
  ...
}
finally {
  try {
    if(f != null) {
      f.close();
    }
  }
  catch(IOException e) {
    // Nothing can be done, except maybe log it.
  }
}