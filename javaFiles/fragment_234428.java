public void testZipOrder() throws Exception {
    File file = new File("zip.zip");
    ZipInputStream zis = new ZipInputStream(new FileInputStream(file));
    ZipEntry entry = null;
    while ( (entry = zis.getNextEntry()) != null ) {
     System.out.println( entry.getName());
    }
    zis.close();
}