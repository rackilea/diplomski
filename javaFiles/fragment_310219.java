public static void main(String[] args) {
  Multimap<String, String> first = ArrayListMultimap.create();
  Multimap<String, String> second = ArrayListMultimap.create();

  first.put("foo", "foo");
  first.put("foo", "bar");
  first.put("foo", "baz");
  first.put("bar", "foo");
  first.put("baz", "bar");

  second.put("foo", "foo");
  second.put("foo", "bar");
  second.put("baz", "baz");
  second.put("bar", "foo");
  second.put("baz", "bar");

  Multimap<String, String> firstSecondDifference =
      Multimaps.filterEntries(first, e -> !second.containsEntry(e.getKey(), e.getValue()));

  Multimap<String, String> secondFirstDifference =
      Multimaps.filterEntries(second, e -> !first.containsEntry(e.getKey(), e.getValue()));

  System.out.println(firstSecondDifference);
  System.out.println(secondFirstDifference);
}