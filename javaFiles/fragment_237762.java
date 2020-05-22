public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            GUI gui = new GUI();
            gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            gui.setSize(600, 400);
            gui.setResizable(true);
            gui.setVisible(true);
        }
    });
}