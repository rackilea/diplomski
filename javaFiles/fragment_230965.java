static <T> List<Set<T>> mergeSets(Collection<? extends Set<T>> unmergedSets) {
  final List<Set<T>> mergedSets = new ArrayList<>(unmergedSets);

  List<Integer> mergeCandidate = Collections.emptyList();
  do {
    mergeCandidate = findMergeCandidate(mergedSets);

    // apply the merge
    if (!mergeCandidate.isEmpty()) {
      // gather the sets to merge
      final Set<T> mergedSet = Sets.union(
          mergedSets.get(mergeCandidate.get(0)),
          mergedSets.get(mergeCandidate.get(1)));

      // removes both sets using their index, starts with the highest index
      mergedSets.remove(mergeCandidate.get(0).intValue());
      mergedSets.remove(mergeCandidate.get(1).intValue());

      // add the mergedSet
      mergedSets.add(mergedSet);
    }
  } while (!mergeCandidate.isEmpty());

  return mergedSets;
}

// O(n^2/2)
static <T> List<Integer> findMergeCandidate(List<Set<T>> sets) {
  for (int i = 0; i < sets.size(); i++) {
    for (int j = i + 1; j < sets.size(); j++) {
      if (Sets.intersection(sets.get(i), sets.get(j)).size() == 2) {
        return Arrays.asList(j, i);
      }
    }
  }
  return Collections.emptyList();
}