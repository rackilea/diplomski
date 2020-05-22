public static void main(String args[]) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame frame = new JFrame("Wolves & Rabbits");
            frame.setSize(640, 480);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // want to create a 12x9 grid with 2 black and 4 pink rectangles
            Board board = new Board(12, 9, 2, 4, 1000);

            frame.add(board);

            frame.setResizable(false);
            frame.setVisible(true);
        }
    });
}