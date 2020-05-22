InputStream getExportInfo(path) {
  def zipFile = new java.util.zip.ZipFile(new File(path))

  for( ZipEntry entry in zipFile.entries() ){
    def name = entry.name
    if (!entry.directory && name == "ExportInfo") {
      return zipFile.getInputStream(entry)
    }
  }
}