private File writeFileDataToFile(HttpURLConnection connection) {
    if (!this.file.exists()) {
        try {
            this.file.getParentFile().mkdirs();
            //this.file.createNewFile(); // not needed, will be created at FileOutputStream
        } catch (IOException e) {
            System.out.println("Error while creating file at " + file.getPath());
            //System.exit(1);
            // instead do a throw of error or return null
            throw new YourException(message);
        }
    }
    OutputStream output = null;
    InputStream input = null;
    try {
      output = new FileOutputStream(file):
      input = connection.getInputStream();
      byte[] fileChunk = new byte[8*1024];
      int bytesRead;
      while ((bytesRead = input.read(fileChunk )) != -1) {
         output.write(fileChunk , 0, bytesRead);
      }
      return file;
    } catch (IOException e) {
      System.out.println("Receiving file at " + url.toString() + " failed");
      // System.exit(1); // you should avoid such exit
      // instead do a throw of error or return null
      throw new YourException(message);
    } finally {
      if (input != null) {
        try {
           input.close();
        } catch (Execption e2) {} // ignore
      }
      if (output != null) {
        try {
           output.close();
        } catch (Execption e2) {} // ignore
      }
    }
}