public static void main(String[] args) {
    HelloWorld.init(args);
    SwingUtilities.invokeLater( new Runnable() {
        public void run() {
            new Main();
        }
    });   
    HelloWorld.check();
}