Scanner sc = new Scanner(new File(filename));
List<String> lines = new ArrayList<String>();
while (sc.hasNextLine()) {
  lines.add(sc.nextLine());
}

String[] arr = lines.toArray(new String[0]);