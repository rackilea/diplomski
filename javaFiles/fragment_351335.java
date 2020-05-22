@Test
public void showJustOneCircle() throws InterruptedException {
    JFrame frame = new JFrame("JustOneCircle");
    JustOneCircle oneCircle = new JustOneCircle();
    frame.add(oneCircle);
    frame.setSize(200, 200);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.setVisible(true);
    oneCircle.init();
    oneCircle.start();
    // the applet will be closed after 5 seconds
    TimeUnit.SECONDS.sleep(5);
}