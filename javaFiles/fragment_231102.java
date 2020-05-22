public static void copy(InputStream is, OutputStream os) throws IOException {
      byte buffer[] = new byte[8192];
      int bytesRead;

      BufferedInputStream bis = new BufferedInputStream(is);
      while ((bytesRead = bis.read(buffer)) != -1) {
              os.write(buffer, 0, bytesRead);
      }
      is.close();
      os.flush();
      os.close();
}