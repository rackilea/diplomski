Reader r = new InputStreamReader(new FileInputStream(theFile), "Windows-1256");
BufferedReader buffered = new BufferedReader(r);
try {
  String line;
  while ((line = buffered.readLine()) != null) {
    // handle each line
  }
} finally {
  buffered.close();
}