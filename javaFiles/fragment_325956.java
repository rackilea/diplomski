path = path.replace("/", "\\");
Map<String, String> map = new HashMap<String, String>();

for (String line : Files.readAllLines(Paths.get(path + fileName), Charset.defaultCharset())) {
  String[] pieces = line.split("\\s", 2);
  map.put(pieces[0], pieces[1]);
}

return map;