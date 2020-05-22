private static Set<String> getIntersectionSet() {
    // create a deep copy of one (in case you don't wish to modify it)
    Set<String> interQrels = new HashSet<>(one);

    interQrels.retainAll(two);     // intersection with two (and one)
    interQrels.retainAll(three);   // intersection with three (and two, one)
    interQrels.retainAll(four);    // intersection four (and three, two, one)

    return interQrels;
}