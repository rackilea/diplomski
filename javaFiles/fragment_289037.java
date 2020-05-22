String word = "foo";
int[] i = new int[]{0};
List<Integer> hits = Stream.of("foo", "bar", "foobar")
.map(s -> s.contains(word) ? ++i[0] : - ++i[0])
.filter(n -> n > 0)
.collect(Collectors.toList());
System.out.println(hits);