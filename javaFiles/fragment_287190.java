public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable(){
        @Override
        public void run() {
            Main m = new Main();
        }
    });
}