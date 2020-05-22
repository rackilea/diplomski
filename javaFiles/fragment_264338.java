Map<String, String> keyValueMap = new HashMap<String,String>();

String[] lines = input.split("\n");
if (lines == null) {
  //Compensate for strange JDK semantics
  lines = new String[] { input };
}

for (String line : lines) {
  if (!line.contains(":")) {
    //Skip lines that don't contain key-value pairs
    continue;
  }
  String[] parts = line.split(":");
  keyValueMap.put(parts[0], parts[1]);
}

return keyValueMap;