try
  {
    try (baos = new ByteArrayOutputStream();
         zos = new ZipOutputStream(baos))
    {
      for (RepBean rep : repsList)
      {
        String filename = rep.getFilename();
        ZipEntry entry = new ZipEntry(filename);
        entry.setSize(rep.getContent().length);
        zos.putNextEntry(entry);
        zos.write(rep.getContent());
        zos.closeEntry();
      }
    }
    // this is the zip file as byte[]
    reportContent = baos.toByteArray();
  }
  // catch blocks as before, finally is no longer required as the try-with-resources
  // will ensure the streams are closed