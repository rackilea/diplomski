Set<String> intersection = new HashSet<String>(set1);
intersection.retainAll(set2);

if (intersection.size() > 0) {
    // print true
} else {
    // print false
}