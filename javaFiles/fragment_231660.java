private void forEachSet(List<Integer> currentSet, List<Integer> rest) {
    if (rest.isEmpty()) {
        process(currentSet);
    } else {
        Integer nextInt = rest.remove(0);
        forEachSet(currentSet, rest);
        currentSet.add(nextInt);
        forEachSet(currentSet, rest);
        current.remove(nextInt);
        rest.add(nextInt);
    }
}

public forEachSet(List<Integer> set) {
    forEachSet(new ArrayList<>(), new ArrayList<>(set));
}