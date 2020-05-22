static Blank[] copy(Blank[] ts){
    Blank[] ts_copy = new Blank[ts.length];
    for (int i=0; i<ts.length; i++) {
        ts_copy[i] = ts[i].clone();
    }
    return ts_copy;
}