for (int i = 0; i < A.length; i++) {
    boolean found = false;
    for (int j = 0; j < foundNumbers.size(); j++) {
        if (A[i] == foundNumbers.get(j)) {
            found = true;
            break;
        }
    }
    if (!found) {
        foundNumbers.add(A[i]);
    }
}