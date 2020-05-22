Set<Pair> set = new HashSet<Pair>();
for(Bundle primaryOperand : bundleComparators) {
  for(Bundle secondaryOperand : sortedBundles) {
    Pair p = new Pair(primaryOperand.id, secondaryOperand.id);
    if(set.contains(p)) 
      continue;

    set.add(p);
    outputJoin(primaryOperand, secondaryOperand);
  }
}