public Set<B> getBs(){
    Iterator<A> iterator = myFunc.iterator();
    Set<B> result = new HashSet<B>();
    while (iterator.hasNext()) {
        A a = iterator.next();
        if (a instanceof B) {
            result.add((B) iterator.next();
        }
    }
    return result;
}