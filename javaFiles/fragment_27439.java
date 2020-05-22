SortedSet<Integer> set = new TreeSet<> ();
set.addAll(map.keySet());
set.addAll(map.values());

//return true if input within the range
return (input >= set.first() || input <= set.last());