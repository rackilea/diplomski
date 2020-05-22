class SearchPath {
    int x, y;
    String string;
    SearchPath prior;

    // x,y are most recent position; prior is the path up to this point, or null
    public SearchPath(int x, int y, String board, SearchPath prior) {
        this.x = x;
        this.y = y;
        this.string = (prior != null ? prior.string : "") + board[x][y];
        this.prior = prior;
    }

    // To check if an x,y location collides with this path
    public contains(int x, int y) {
        if (this.x == x && this.y == y) {
            return true;
        } else if (prior == null) {
            return false;
        } else {
            return prior.contains(x,y);
        }
    }
}