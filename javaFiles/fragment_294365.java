public class UnionFindArray {

@Test
public void test() {

    int a[][] = {{ 1, 0, 0, 1 }, {1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 0}};

    int nRows = a.length;
    int nCols = a[0].length;

    UnionFind uf = new QuickUnionFind(nRows*nCols);  // This is my implementation - you need to substitute yours

    // Examine all neighbours
    for (int row = 0; row < nRows; row++) {
        for (int col = 0; col < nCols; col++) {
            if (row < nRows-1 && a[row][col]==a[row+1][col])
                uf.union(getId(row,col,nCols), getId(row+1,col,nCols));
            if (col < nCols-1 && a[row][col]==a[row][col+1])
                uf.union(getId(row,col,nCols), getId(row,col+1,nCols));
        }
    }

    assertEquals(6, uf.getNumberOfTrees());  // True - there are 3 trees of zeros, and 3 trees of ones

}

private int getId(int row, int col, int nCols) {
    return row*nCols + col;
}

}