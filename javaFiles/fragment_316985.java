HashSet<Character> tmp = new HashSet<Character>();
for (char ch : arr1) {
    tmp.add(ch);
}
for (char ch : arr2) {
    if (tmp.contains(ch)) {
        // elements in common!!
    }
}