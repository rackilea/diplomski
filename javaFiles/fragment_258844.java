private void addContent(int r, int c, int d) {
    Border border = BorderFactory.createLineBorder(Color.black, 2);
    for (int i = 0 ; i < r ; i++) {
        for (int j = 0 ; j < c ; j++) {
            f.add(new TicTacToeCell(border, d, d));
        }
    }
}