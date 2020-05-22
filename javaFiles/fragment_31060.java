JFrame frame=...;

 ...

//show splash
if (!showSplash()) {
     JOptionPane.showMessageDialog(null, "SplashScreen could not be shown!", "Splash Error: 0x003", JOptionPane.ERROR_MESSAGE);
 }

// set JFrame visible
frame.setVisible(true);
frame.toFront();