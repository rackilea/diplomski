// assuming you have List<List<?>> lists that is non-empty
  Set<?> result = Sets.newLinkedHashSet(lists.get(0));
  for (int i = 1; i < lists.size(); i++) {
    result.retainAll(ImmutableSet.copyOf(lists.get(i)));
  }

  return result;