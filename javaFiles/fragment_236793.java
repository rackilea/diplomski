....
  makeEntry(zos,file.getFileName().toString(),resultSetFirst);
  makeEntry(zos,filefacts.getFileName().toString(),resultSetSecond);
  makeEntry(zos,fileEncounters.getFileName().toString(),resultSetThird);
....
}

private static void makeEntry(ZipOutputStream zos,String name, ResultSet res) throws SomeExceptions{
    zos.putNextEntry(new ZipEntry(name));
    try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(zos,StandardCharsets.UTF_8))){
      writer.writeAll(res, true);
      writer.flush();
      zos.closeEntry();
  }
}