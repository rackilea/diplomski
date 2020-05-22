List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3));
List<String> list2 = (List) list;
list2.add("Hello World");

Integer i = list.get(0); // works
String s = list2.get(3); // works
s = list2.get(1); // ClassCastException
i = list.get(3); // ClassCastException