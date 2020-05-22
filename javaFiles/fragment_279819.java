//now uf is a local variable inside a Percolation object
private WeightedQuickUnionUF uf;

public Percolation(int n) {              
    length = n + 2;
    //now uf is created whenever you create a Percolation object
    uf = new WeightedQuickUnionUF(length);
}