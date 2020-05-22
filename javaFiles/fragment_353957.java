Set<Integer> values = new HashSet<Integer>();
for (int j = 0, x; j < m; j++) {
    for (int i = 0; i < n; i++) {
        x = X[i][j];
        if (!values.add(x)) continue; //value.add returns true if the element was NOT in the set before
        System.out.println(x);
    }
    values.clear();
}