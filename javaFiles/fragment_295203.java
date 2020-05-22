public static void main(String[] args) throws ClassNotFoundException,
                InstantiationException, IllegalAccessException,
                UnsupportedLookAndFeelException {
    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    SwingUtilities.invokeLater(new Runnable() {
        public void run() {
            InitSplashScreen splashScreen = new InitSplashScreen();
            try {
                splashScreen.initUI(new PropertyChangeListener() {
                    @Override
                    public void propertyChange(PropertyChangeEvent evt) {
                        String name = evt.getPropertyName();
                        if ("state".equalsIgnoreCase(name)) {
                            SwingWorker worker = (SwingWorker) evt.getSource();
                            if (worker.getState().equals(SwingWorker.StateValue.DONE)) {
                                Gui ui = new Gui();
                            }
                        }
                    }
                });
            } catch (MalformedURLException ex) {
                ex.printStackTrace();
            }
        }
    });
}