Set<List<String>> seenAlready = new HashSet<>();
// ...
for (int i = 0; i < 99; i++) {
  final String[] array = generateRandomArrayFromElements(elements);
  Arrays.sort(array);
  if (seenAlready.add(Arrays.asList(array)) {
    System.out.println(Arrays.toString(array));
  }
}