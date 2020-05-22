for (int i = 0; i < v.size(); i++){
    Vector inner = (Vector)v.elementAt(i);
    for (int j = 0; j < inner.size(); j++) {
        m = (int)inner.elementAt(j);
        System.out.print(m + " ");
    }
    System.out.println();
}