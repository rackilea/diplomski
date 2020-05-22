final Set<Integer> commonSet;
final Set<Integer> cSet = new HashSet<Integer>();
final Set<Integer> dSet = new HashSet<Integer>();

cSet.addAll(primeFactors.get(c));
dSet.addAll(primeFactors.get(d));

commonSet = dSet.retainAll(cSet);

return (commonSet.isEmpty());