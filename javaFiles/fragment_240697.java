public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            Grid grid = new Grid();
            GameBoard inst = new GameBoard(grid);
            inst.setLocationRelativeTo(null);
            inst.setVisible(true);
        }
    });
}