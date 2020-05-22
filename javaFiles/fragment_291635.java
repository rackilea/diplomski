public void clearDuplicates(int[] A, int[] B) {
    // Initialize a set of numbers which are not in B to all numbers 0--90
    final Set<Integer> notInB = new HashSet<>();
    for (int i = 0; i <= 90; i++) {
        notInB.add(i);
    }
    // Create a set of numbers which are in B. Since lookups in hash set are
    // O(1), this will be much more efficient than manually searching over B
    // each time. At the same time, remove elements which are in B from the
    // set of elements not in B.
    final Set<Integer> bSet = new HashSet<>();
    for (final int b : B) {
        bSet.add(b);
        notInB.remove(b);
    }

    // Search and remove duplicates
    for (int i = 0; i < A.length; i++) {
        if (bSet.contains(A[i])) {
            // Try to replace the duplicate by a number not in B
            if (!notInB.isEmpty()) {
                A[i] = notInB.iterator().next();
                // Remove the added value from notInB
                notInB.remove(A[i]);
            }
            // If not possible, return - there is no way to remove the
            // duplicates with the given constraints
            else {
                return;
            }
        }
    }
}