public boolean hasNext() {
    return row < matrix.length && col < matrix[row].length;
}

public T next() {
    if (!hasNext()) {
        throw ...
    } else if (col < matrix[row].length) {
        return matrix[row][col++];
    } else {
        return matrix[row++][col = 0];
    }
}