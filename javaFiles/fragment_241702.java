HttpServletResponse response = ...
File myfile = ...
InputStream in = null;
OutputStream out = null;
try {
  in = new FileInputStream(myfile);
  out = response.getOutputStream();
  IOUtils.copy(in, out);
} finally {
  IOUtils.closeQuietly(in); //checks for null
  IOUtils.closeQuietly(out); //checks for null
}