final Iterator<Object> iterator = c1.iterator();

while (iterator.hasNext()) {

    final Object o = iterator.next();
    if (satisfiesSomeCriterion(o)) iterator.remove();
}