public int minIndex(double... ds) {
    int idx = -1;
    double d= Double.POSITIVE_INFINITY;
    for(int i = 0; i < ds.length; i++)
        if(ds[i] < d) {
            d = ds[i];
            idx = i;
        }
    return idx;
}