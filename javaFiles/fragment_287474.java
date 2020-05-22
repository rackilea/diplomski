public static void main(String[] args) {
    // Change the name of the application on a mac
    System.setProperty(
        "com.apple.mrj.application.apple.menu.about.name", "XX");
    // Use the top of the screen for the menu on a mac
    if (System.getProperty("mrj.version") != null) {
        System.setProperty("apple.laf.useScreenMenuBar", "true");
    }

    java.awt.EventQueue.invokeLater(new Runnable() {

        @Override
        public void run() {
            // Create a new instance of XX
            XX.getInstance();
        }
    });
}