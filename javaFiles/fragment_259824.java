List<Integer> results = new ArrayList<>();
  for(int i = 0; i<numbers.size(); i++) {
      results.addAll(subsetSums(new ListWithout(numbers, i));
  }
  results.add(sum(numbers));
  return Collections.unmodifiableList(results);