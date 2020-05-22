final BigDecimal one = new BigDecimal("1");
final BigDecimal oneDotZero = new BigDecimal("1.0");

final Set<BigDecimal> hashSet = new HashSet<>();
// BigDecimal implements Comparable of itself, so we can use that
final Set<BigDecimal> treeSet = new TreeSet<>();

hashSet.add(one);
hashSet.add(oneDotZero);
// hashSet's size is 2: one.equals(oneDotZero) == false

treeSet.add(one);
treeSet.add(oneDotZero);
// treeSet's size is... 1! one.compareTo(oneDotZero) == 0