Map<String,ResultSet> dataMap = new HashMap<>();
  dataMap.put(file.getFileName().toString(),resultSetFirst);
  dataMap.put(filefacts.getFileName().toString(),resultSetSecond);
  dataMap.put(fileEncounters.getFileName().toString(),resultSetThird);

  for (Map.Entry<String,ResultSet> e : dataMap.entrySet()){
    makeEntry(zos, e.getKey(), e.getValue());
  }
...