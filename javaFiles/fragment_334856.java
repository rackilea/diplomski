public void paintComponent(Graphics g) {

    // TODO: delete line below!
    System.out.println("BridgeCanvas Size: " + getSize());

    Graphics2D g2 = (Graphics2D) g;
    super.paintComponent(g); 
    g2.setFont(new Font(Font.MONOSPACED, Font.BOLD, 32));

    // .... etc...

}