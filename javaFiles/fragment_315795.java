private BufferedImage myImage;

public Board() { 
    try {
        myimage = ImageIO.read(this.getClass().getResource("/myimage")); 
    } catch (IOException exp) {
        exp.printStackTrace();
    }
} 

protected void paintComponent(Graphics g) { 
    super.paintComponent(g);
    if (myImage != null) {
        Graphics2D g2d = (Graphics2D) g; 
        g2d.drawImage(myimage, 10, 10, this); 
        System.out.println("Background Image"); 
    }
}