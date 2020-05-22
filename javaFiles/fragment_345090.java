frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
WindowListener wndCloser = new WindowAdapter() {
    public void windowClosing(WindowEvent e) {
        exitProcedure();
    }
};
frame.addWindowListener(wndCloser);


public void exitProcedure() {
    frame.dispose();
    System.exit(0);
}