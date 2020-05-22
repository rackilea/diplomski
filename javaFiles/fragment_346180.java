LongStream a = LongStream.iterate(286, i->i+1).map(i -> Math.multiplyExact(i, i+1)/2);
LongStream b = LongStream.iterate(166, i->i+1).map(i -> Math.multiplyExact(i, 3*i-1)/2);
LongStream c = LongStream.iterate(144, i->i+1).map(i -> Math.multiplyExact(i, 2*i-1));

OfLong aIter = a.iterator();
OfLong bIter = b.iterator();
OfLong cIter = c.iterator();

long aVal = aIter.nextLong();
long bVal = bIter.nextLong();
long cVal = cIter.nextLong();
while (aVal != bVal || bVal != cVal) {
    long min = Math.min(Math.min(aVal, bVal), cVal);
    if (aVal == min)
        aVal = aIter.nextLong();
    if (bVal == min)
        bVal = bIter.nextLong();
    if (cVal == min)
        cVal = cIter.nextLong();
}
System.out.println(aVal);