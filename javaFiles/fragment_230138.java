InputStream in = null;
try {
     in = new FileInputStream("simple.csv");
     BufferedReader buf = new BufferedReader(new InputStreamReader(in));
} finally {
  if (in != null) {
     try {
         in.close();
     } catch (IOException e) {}
  }
}