List<RemoveTest> list = new ArrayList<RemoveTest>();
// populate list
Set<RemoveTest> removals = new HashSet<RemoveTest>();
for (RemoveTest i : list)
    for (RemoveTest j : list)
        if (...)
            removals.add(i); // j will get added in another iteration
list.removeAll(removals);