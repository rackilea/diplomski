JFrame frame = new JFrame(...);
// Show the frame
frame.setVisible(true);

// Sleep for 5 seconds, then minimize
Thread.sleep(5000);
frame.setState(java.awt.Frame.ICONIFIED);

// Sleep for 5 seconds, then restore
Thread.sleep(5000);
frame.setState(java.awt.Frame.NORMAL);