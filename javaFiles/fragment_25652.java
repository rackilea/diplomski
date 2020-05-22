public static void main(String args[]) {
    jFrame = new JFrame("Demo Browser");
    jfxPanel = new JFXPanel();
    jFrame.add(jfxPanel);
    jFrame.setVisible(true);
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    SwingUtilities.invokeLater(new Runnable() {
        @Override
        public void run() {
            Platform.runLater(new Runnable() {
                @Override
                public void run() {
                    browser = new FXBrowser();
                    jfxPanel.setScene(browser.getScene());
                    jFrame.setSize((int) browser.getWebView().getWidth(), (int) browser.getWebView().getHeight());

                    browser.getWebEngine().getLoadWorker().stateProperty().addListener(
                            new ChangeListener() {
                                @Override
                                public void changed(ObservableValue observable,
                                                    Object oldValue, Object newValue) {
                                    State oldState = (State) oldValue;
                                    State newState = (State) newValue;
                                    if (State.SUCCEEDED == newValue) {
                                        captureView();
                                    }
                                }
                            });
                }
            });
        }
    });
}

private static void captureView() {
    BufferedImage bi = new BufferedImage(jfxPanel.getWidth(), jfxPanel.getHeight(), BufferedImage.TYPE_INT_ARGB);
    Graphics graphics = bi.createGraphics();
    jfxPanel.paint(graphics);
    try {
        ImageIO.write(bi, "PNG", new File("demo.png"));
    } catch (IOException e) {
        e.printStackTrace();
    }
    graphics.dispose();
    bi.flush();
}