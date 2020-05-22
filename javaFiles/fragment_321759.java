public boolean isIdenticalHashSet <A> (HashSet h1, HashSet h2) {
    if ( h1.size() != h2.size() ) {
        return false;
    }
    HashSet<A> clone = new HashSet<A>(h2); // just use h2 if you don't need to save the original h2
    Iterator it = h1.iterator();
    while (it.hasNext() ){
        A = it.next();
        if (clone.contains(A)){ // replace clone with h2 if not concerned with saving data from h2
            clone.remove(A);
        } else {
            return false;
        }
    }
    return true; // will only return true if sets are equal
}