Reader reader = new BufferedReader(new FileReader("input.txt"));
String line;
List<ColorPair> colorPairs = new ArrayList<ColorPair>();
while((line = reader.readLine()) != null) {
  colorPairs.add(parseColorPair(line));
}

// Output in original order
for(ColorPair colorPair: colorPairs) {
  System.out.println(colorPair); // using our custom ColorPair.toString() method
}