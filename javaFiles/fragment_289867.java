private static int[][] rotate( final int[][] piece ) {
    final int[][] res = new int[piece[0].length][piece.length];
    for (int x = 0; x < piece.length; x++) {
        for (int y = 0; y < piece[0].length; y++) {
            res[(res.length-1)-y][x] = piece[x][y];
        }
    }
    return res;
}