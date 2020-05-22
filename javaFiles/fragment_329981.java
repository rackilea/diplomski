public ArrayList<Integer> findDuplicates
    (ArrayList<Integer> list1, ArrayList<Integer> list2) {

    Set<Integer> duplicates = new HashSet<>(list1);
    duplicates.retainAll(new HashSet<>(list2));
    return new ArrayList<>(duplicates);
}