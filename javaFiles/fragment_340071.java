List<String> list = Arrays.asList("A", "B", "C");

StringJoiner joiner = new StringJoiner(",");
for (ListIterator<String> iter = list.listIterator(list.size()); iter.hasPrevious(); )
    joiner.add(iter.previous());
String result = joiner.toString();

System.out.println(result); // print: C,B,A