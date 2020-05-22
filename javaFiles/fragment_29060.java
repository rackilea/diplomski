public void createWindow(){
    frame.add(panel);  // what is panel? do you override *its* paintComponent?
    frame.addComponentListener(this);
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLocationRelativeTo(null);
    frame.pack();
    frame.setSize(xSize, ySize);
    frame.setLocation(0, 0);
}