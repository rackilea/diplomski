List<String> strings = new ArrayList<String>();
List<Integer> ints = new ArrayList<Integer>();

while(scanner.hasNext() && !scanner.hasNextInt()) {
    strings.add(scanner.next());
}
while(scanner.hasNextInt()) { // If you also want to store the ints
    ints.add(scanner.nextInt());
}