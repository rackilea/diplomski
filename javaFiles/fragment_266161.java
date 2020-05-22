frame.dispose();
if (b) {
    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    frame.setUndecorated(true);
} else {
    frame.setExtendedState(JFrame.NORMAL);
    frame.setUndecorated(false);
}
frame.setVisible(true);