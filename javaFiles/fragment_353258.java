public static void main(String[] args) throws IOException {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            new MainFrame().setVisible(true);
        }
    });
}