public static List<Integer> withoutDuplicates(List<Integer> withDuplicates) {
    List<Integer> retVal = new ArrayList<>();
    Set<Integer> alreadyParsed = new HashSet<>();
    for (Integer val : withDuplicates) {
        if (!alreadyParsed.contains(val)) {
             retVal.add(val);
             alreadyParsed.add(val);
        }
    }
    return retVal;
}