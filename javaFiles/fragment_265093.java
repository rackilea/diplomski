final ListIterator<Integer> iterator = c1.listIterator();

while (iterator.hasNext()) {

    final Integer o = iterator.next();
    if (satisfiesSomeCriterion(o)) iterator.add(Integer.valueOf(o.intValue() + 10);
}