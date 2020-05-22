....
  Map<String,ResultSet> dataMap = new HashMap<>();
  dataMap.put(file.getFileName().toString(),resultSetFirst);
  dataMap.put(filefacts.getFileName().toString(),resultSetSecond);
  dataMap.put(fileEncounters.getFileName().toString(),resultSetThird);

  for (Map.Entry<String,ResultSet> e : dataMap.entrySet()){
    zos.putNextEntry(new ZipEntry(e.getKey()));
    try (CSVWriter writer = new CSVWriter(new OutputStreamWriter(zos,StandardCharsets.UTF_8))){
      writer.writeAll(e.getValue(), true);
      writer.flush();
      zos.closeEntry();
    }
  }
....