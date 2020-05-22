private boolean swap;
private Timer timer;

....

final Image onImage = new ImageIcon(ImageIO.read(new File("resources/1.png"))).getImage();
final Image offImage = new ImageIcon(ImageIO.read(new File("resources/2.png"))).getImage();

// interval of 500 milli-seconds
timer = new Timer(500, new ActionListener() {

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (swap) {
            setIconImage(onImage);
        } else {
            setIconImage(offImage);
        }
        swap = !swap;
    }
});
timer.setRepeats(true);

// check whether window is in ICONIFIED state or not
if (getExtendedState() == JFrame.ICONIFIED) {
    timer.start();
}


addWindowListener(new WindowAdapter() {

    public void windowDeiconified(WindowEvent e) {
        // set the icon back to default when window is DEICONIFIED 
        timer.stop();
    }
});