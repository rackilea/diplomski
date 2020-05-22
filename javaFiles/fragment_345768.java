public static void main(String args) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            JFrame jframe = new JFrame("Game");

            Game game = new Game();
            jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
            jframe.add(game);
            jframe.pack();
            jframe.setLocationRelativeTo(null);
            jframe.setVisible(true);
            game.start();
        }
    });
}