Set<String> oldSet = Sets.newHashSet("a", "b", "c");
    Set<String> newSet = Sets.newHashSet("b", "d");


    Sets.SetView<String> toRemove = Sets.difference(oldSet, newSet);
    Sets.SetView<String> toInsert = Sets.difference(newSet, oldSet);
    Sets.SetView<String> toUpdate = Sets.intersection(oldSet, newSet);