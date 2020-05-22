public int solution(int[] A) {
    Set<Integer> checkedNumbers = new HashSet<>();
    for (int i=0; i< A.length; i++) {
        if (!checkedNumbers.add(A[i])) { // try to add the element
            checkedNumbers.remove(A[i]); // remove it if it's already in the Set
        }
    }
    return checkedNumbers.iterator().next();
}