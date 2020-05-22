public void createWindow(){
    frame.add(this);  // ******  Here you go ****
    frame.addComponentListener(this);  // Not sure what this is for
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setVisible(true);
    // frame.setSize(xSize, ySize); // *** avoid this guy
    frame.setLocation(0, 0);
}