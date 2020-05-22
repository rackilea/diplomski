path = path.replace("/", "\\");
Map<String, String> map = new HashMap<String, String>();
BufferedReader reader = new BufferedReader(new InputStreamReader(
    new FileInputStream(path + fileName)));

while (true) {
  String line = reader.readLine();
  if (line == null) {
    break;
  }
  String[] pieces = line.split("\\s", 2);
  map.put(pieces[0], pieces[1]);
}

reader.close();
return map;