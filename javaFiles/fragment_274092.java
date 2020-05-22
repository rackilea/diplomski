Set<String> keysInA = new HashSet<String>(mapA.keySet());
Set<String> keysInB = new HashSet<String>(mapB.keySet());

// Keys in A and not in B
Set<String> inANotB = new HashSet<String>(keysInA);
inANotB.removeAll(keysInB);

// Keys common to both maps
Set<String> commonKeys = new HashSet<String>(keysInA);
commonKeys.retainAll(keysInB);