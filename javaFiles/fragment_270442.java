public List<String> getEqualsPart(List<String>[] listsToCheck) {
    if (listsToCheck.length == 0) {
        return Collections.emptyList();
    }
    int minLength = getShortesListLength(listsToCheck);
    if (minLength == 0) {
        return Collections.emptyList();
    }
    return getEqualPartsForIndex(listsToCheck, 0, minLength, new ArrayList<String>());

}

private int getShortesListLength(List<String>[] listsToCheck) {
    int min = Integer.MAX_VALUE;
    for (List<String> currentList : listsToCheck) {
        min = Math.min(min, currentList.size());
    }
    return min;
}

private List<String> getEqualPartsForIndex(List<String>[] listsToCheck, int index, int minLength,
        List<String> result) {
    if (index == minLength) {
        return result;
    }
    Set<String> setForIndex = new HashSet<>();
    Arrays.stream(listsToCheck).forEach(list -> setForIndex.add(list.get(index)));
    if (setForIndex.size() > 1) {
        return result;
    } else {
        result.add(setForIndex.iterator().next());
        return getEqualPartsForIndex(listsToCheck, index + 1, minLength, result);
    }

}`