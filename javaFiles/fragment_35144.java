public static void main(String[] args) {
    SwingUtiliities.invokeLater(new Runnable(){
        public void run() {
            new Images();
        }
    });
}