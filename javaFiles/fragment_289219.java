List<String> findDuplicates(List<String> original) {
    Set<String> seen = new HashSet<String>();
    Set<String> seenTwice = new HashSet<String>();

    for (String s: original) {
        if (!seen.add(s)) {
            seenTwice.add(s);
        }
    }
    return new ArrayList<String>(seenTwice);
}