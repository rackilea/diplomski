BufferedWriter buf = null;
OutputStream out = null;
try {
    out = new FileOutputStream("file");
    buf = new BufferedWriter(new OutputStreamWriter(out));
} finally {
  if (buf != null) {
     try { buf.close(); } catch (IOException ex){}
  }
  if (out != null) {
     try { out.close(); } catch (IOException ex){}
  }
}