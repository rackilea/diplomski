public static void main(String[] args) {
    java.awt.EventQueue.invokeLater(new Runnable() {
        public void run() {
            TicTacToeGame frame = new TicTacToeGame("pax","diablo");
            frame.setVisible(true);
        }
    });
}