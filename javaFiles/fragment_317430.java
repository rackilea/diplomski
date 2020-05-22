TreeSet<String> set = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
set.addAll(Arrays.asList("1A", "2C", "4D", "3F", "5B", "6E"));
String input = walther.nextLine();
if (set.contains(input)) {
   ++x;
   walther.close();
}