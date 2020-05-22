static synchronized void swapValues(Cell c1, Cell c2) {

    int t = c1.getValue();
    System.out.println("Swapping " + t);
    int v = c2.getValue();
    System.out.println("with " + v);
    c1.setValue(v);
    c2.setValue(t);

    System.out.println("Cell is now " + c1.getValue());
    System.out.println("Cell was " + c2.getValue());
}