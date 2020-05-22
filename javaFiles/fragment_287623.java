static boolean mazeTraversal(char m[][], int i, int j) {
    if (m[i][j] == '#')
        return false;
    if (m[i][j] == 'B')
        return true;
    if (m[i][j] == '*')    // <-- added check
        return false;
    // marking as a part of path
...