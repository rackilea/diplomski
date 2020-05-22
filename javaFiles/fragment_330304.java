Map<String, Pattern> map = new HashMap<>();

for(int i = 0; i < regex.length; i++) {
  String[] splitLine = regex[i].split(" ", 2);
  map.put(splitLine[0], Pattern.compile(splitLine[1]));

}