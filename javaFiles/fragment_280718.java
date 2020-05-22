public static LinkedList<Integer> removeAll(LinkedList<Integer> L1, Collection<Integer> L2) {
    LinkedList<Integer> temp = new LinkedList<>();
    HashSet<Integer> L2Set = new HashSet<>(L2); // O(m)

    // first filter elements into temp
    while (L1.size() > 0) { // n loops
        int v = L1.removeFirst(); // O(1)
        if (!L2Set.contains(v)) { // O(1)
            temp.addLast(v);      // O(1)
        }
    }

    // add filtered values back to L1
    while (temp.size() > 0) {     // About n loops
        L1.addLast(temp.removeFirst()); // O(1)
    }

    return L1;
}