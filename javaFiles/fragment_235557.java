public int solution(int[] A) {
    Set<Integer> checkedNumbers = new HashSet<>();
    for (Integer number : A) {
        if (!checkedNumbers.add(number)) { // try to add the element
            checkedNumbers.remove(number); // remove it if it's already in the Set
        }
    }
    return checkedNumbers.iterator().next();
}