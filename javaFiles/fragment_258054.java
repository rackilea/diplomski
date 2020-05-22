public void paintComponent(Graphics g){
    super.paintComponent(g);
    // 'RXDisplayCanvas' is the JPanel.
    Graphics2D G2D = (Graphics2D)RXDisplayCanvas.getGraphics();
    ..
    G2D.dispose();
}