public void withWildCard(List<? extends Collection<Integer>> collections) { 
    ...
}

public void withoutWildCard(List<Collection<Integer>> collections) { 
    ...
}

List<Collection<Integer>> listOfCollections;
withWildcard(listOfCollections); // valid call
withoutWildcard(listOfCollections); // valid call

List<List<Integer>> listOfLists;
withWildcard(listOfLists); // valid call becase List is a subclass of Collection
withoutWildcard(listOfLists); // invalid call, does not compile because List does not match Collection