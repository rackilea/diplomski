void show() {
    mainWin.add(wall);
    mainWin.setResizable(false); // Call me first
    mainWin.pack();
    mainWin.setLocationRelativeTo(null);
    mainWin.setVisible(true);
}