public static void main(String [] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            //Instantiating MyFrames, the class with Frame and Panel
            MyFrames myFrames = new MyFrames();
            myFrames.frameSetup();
        }
    });
}