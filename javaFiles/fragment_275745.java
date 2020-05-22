void deepCopy(boolean[][] orig) {
    synchronized(orig) {
        boolean[][] result = new boolean[orig.length][];
        deepCopy(orig,0);
        return result;        
    }
}

/**
 * recursive method to lock all rows in an array, and then copy
 * them in (backwards, by chance)
 */
void deepCopy(boolean[][] orig, int row) {
    if(row == orig.length) return; // end condition
    synchronized(orig[row]) { // lock the row first
        deepCopy(orig,row+1); // lock the next row
        content[row] = new boolean[orig[row].length];
        for(int i = 0; i < content[row].length; i++)
            content[row][i] = orig[row][i];
        // now, do row - 1
    }
}