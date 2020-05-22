public static void main(String[] args) {
    ArrayList<String> t = new ArrayList<String>();
    t.add("folder1/sub-folder1");
    t.add("folder2/sub-folder2");
    t.add("folder1/sub-folder1/data");
    System.out.println(mostRepeatedSubString(t));
  }

  public static String mostRepeatedSubString(List<String> pathArray) {
    return pathArray
      .stream()
      // Split to lists of strings
      .map(s -> Arrays.asList(s.split("/")))
      // Group by first folder
      .collect(Collectors.groupingBy(lst -> lst.get(0)))
      // Find the key with the largest list value
      .entrySet()
      .stream()
      .max((e1, e2) -> e1.getValue().size() - e2.getValue().size())
      // Extract that largest list
      .map(Entry::getValue)
      .orElse(Arrays.asList())
      // Intersect the lists in that list to find maximal matching
      .stream()
      .reduce(YourClassName::commonPrefix)
      // Change back to a string
      .map(lst -> String.join("/", lst))
      .orElse("");
  }

  private static List<String> commonPrefix(List<String> lst1, List<String> lst2) {
    int maxIndex = 0;
    while(maxIndex < Math.min(lst1.size(), lst2.size())&& lst1.get(maxIndex).equals(lst2.get(maxIndex))) {
      maxIndex++;
    }

    return lst1.subList(0, maxIndex);
  }