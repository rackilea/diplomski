List<String> arrayList = new ArrayList<>();
int words = 0;

Scanner scan = new Scanner(System.in);
while (scan.hasNext()) {
  String line = scan.nextLine();
  arrayList.add(line);
  words += line.split(" ").length;
  System.out.println("lines: " + arrayList.size());
  System.out.println("words: " + words);
}

scan.close();