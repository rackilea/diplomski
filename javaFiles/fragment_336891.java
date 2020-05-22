Scanner in2 = new Scanner(text);
String line;
while ((line = in2.nextLine()) != null) { // <-- read all the lines
  String[] strings = line.split(" ");
  for (String str : strings) {
    if (str.length() < counts.length) {
      counts[str.length()]++;
    }
  }
}