public Set<Integer> findTopNNumbersInLargeList(final List<Integer> largeNumbersList, 
  final int highestValCount) {

  TreeSet<Integer> highestNNumbers = new TreeSet<Integer>();

  for (int number : largeNumbersList) {
    highestNNumbers.add(number);
    if (highestNNumbers.size() > highestValCount) {
      highestNNumbers.pollFirst();
    }
  }
  return highestNNumbers;
}