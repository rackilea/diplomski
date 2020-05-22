OutputStream out = null;
 InputStream filecontent = null;

 try {
    out = new FileOutputStream(new File("destination_file_path"));
    filecontent = filePart.getInputStream();

    int read = 0;
    final byte[] bytes = new byte[1024];

    while ((read = filecontent.read(bytes)) != -1) {
        out.write(bytes, 0, read);
    }
} catch (FileNotFoundException f) {

} finally {
  if (out != null) {
        out.close();
    }
}