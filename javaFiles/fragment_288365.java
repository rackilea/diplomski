List<Integer[]> unique = new ArrayList<Integer[]>();

for (Integer[] arr: list1) {
    // Use your method here, to test whether this value - `arr` 
    // is already in `unique` List or not. If not, then add it.
    if (!contains(unique, arr)) {
        unique.add(arr);
    }
}

for (Integer[] arr: unique) {
    System.out.println(arr);
}