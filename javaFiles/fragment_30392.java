private Node<String> createTree( int firstRow, int lastRow, int lastCol) {

    // Recursion end. If we are at the leftmost column, just return a simple
    // node with the value at the current row and column.
    if ( lastCol == 0 ) {
        return new Node<String>( data[firstRow][0] );
    }

    // Create a node with the value of the top-right cell in our range.
    Node<String> result = new Node<String>(data[firstRow][lastCol]);

    // The next column from the right will have the values for the child nodes.
    // Split it into ranges (start row -> end row) and recursively build
    // the tree over the sub-matrix that goes column 0 -> lastCol-1 over each
    // range of rows.

    int childFirstRow = firstRow;
    String childVal = data[firstRow][lastCol-1];

    for( int candidateRow = firstRow; candidateRow <= lastRow; candidateRow ++ ) {
        // If the next value in the column is different from what we had so far, it's
        // the end of a row range, build the child tree, and mark this row as
        // the beginning of the next range.
        if ( ! data[candidateRow][lastCol-1].equals(childVal) ) {
            result.addChild(createTree( childFirstRow, candidateRow - 1, lastCol - 1));
            childFirstRow = candidateRow;
            childVal = data[childFirstRow][lastCol-1];
        }
        // In the special case of the last row, it's always the end of a range.
        if ( candidateRow == lastRow ) {
            result.addChild(createTree(childFirstRow,lastRow,lastCol - 1));
        }
    }

    return result;
}