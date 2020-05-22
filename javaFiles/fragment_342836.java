MyIterator outerIterator = hashSet.iterator();
while (outerIterator.hasNext) {
    MyIterator innerIterator = hashSet.iterator();
    while (innerIterator.hasNext()) {
        Object o1 = outerIterator.next();
        Object o2 = innerIterator.next();
        // Work with o1 and o2.
    }
}