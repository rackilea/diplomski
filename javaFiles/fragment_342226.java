try (InputStream is = new FileInputStream(zipFile); 
     ZipOutputStream zos = new ZipOutputStream(...)) {
     (...)
    IOUtils.copy(is, zos);
     (...)
}