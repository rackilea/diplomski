outer: for (int i : arr1) {
    for (int j : arr2) {
        if (i == j) {
            continue outer;
        }
    }
    System.out.println("Arr2 doesn't contain number: " + i);
}