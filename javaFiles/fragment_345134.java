public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
           Frame_Main mainWindow = new Frame_Main();
           mainWindow.createWindow();
        }
    });
}