for(int i=0; i<n; i++) {
    ArrayList<Short> inner = new ArrayList<>(m);
    for(int j=0; j<m; j++)
        inner.add(null); // or some other initial value
    VOL_2D.add(inner);
}