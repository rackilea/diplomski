Scanner s = new Scanner(file object pointing at file));
List<String> listOfLines = new ArrayList<String>();
while (s.hasNext()) {
   listOfLines.add(s.next());
}
s.close();