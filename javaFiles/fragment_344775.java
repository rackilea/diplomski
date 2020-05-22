public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {

        @Override
        public void run() {
            Design design = new Design();
            design.pack();
            design.setVisible(true);
        }
    });
}