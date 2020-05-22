import java.math.BigDecimal

List<BigDecimal> l = new ArrayList<>();
l.add(new BigDecimal(1));
l.add(new BigDecimal(2));
l.add(new BigDecimal(3));
l.add(new BigDecimal(4));
l.add(new BigDecimal(5));
l.add(new BigDecimal(6));
l.add(new BigDecimal(7));

List<List<BigDecimal>> findPattern = splitLists(l, 5, new BigDecimal (0));