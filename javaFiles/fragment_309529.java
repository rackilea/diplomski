Map newEntries = new HashMap();
  Iterator x = dlCovs.keys();
  while (x.hasNext()){
    String key1 = (String) x.next();
    String value1 = dlCovs.optString(key1);
    newEntries.put("covabbrv",key1);
    // .. etc
  }

  dlCovs.putAll(newEntries);