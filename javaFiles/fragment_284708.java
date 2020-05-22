try {
  // Open the ZIP file
  ZipFile zf = new ZipFile("filename.zip");

  // Enumerate each entry
  for (Enumeration entries = zf.entries(); entries.hasMoreElements();) {
    // Get the entry name
    String zipEntryName = ((ZipEntry)entries.nextElement()).getName();
  }
} catch (IOException e) {
}