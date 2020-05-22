JFrame frame = new JFrame("Testing");
frame.setAlwaysOnTop(true);
frame.setUndecorated(true);
frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
frame.add(new BackgroundPane());
frame.setLocation(0, 0);
frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
frame.setSize(dim);
// This will stop the background window from become focused,
// potentially hiding the other windows
frame.setFocusableWindowState(false);
frame.setFocusable(false);
frame.setVisible(true);

JFrame dialog = new JFrame();
// Will need to add this to each frame...
dialog.setAlwaysOnTop(true);
dialog.setContentPane(new InstallPane());
dialog.pack();
dialog.setLocationRelativeTo(frame);
dialog.setVisible(true);