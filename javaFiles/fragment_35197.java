public TestGUI()
{
    panel = new Panel();
    GraphicsDevice gd = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice();
    setUndecorated(true);
    gd.setFullScreenWindow(this);
    setVisible(false); // use the workaround to the Mac OS X FSEM bug where mouseMotionListeners don't work right away
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    getContentPane().add(panel);
    setVisible(true);
}