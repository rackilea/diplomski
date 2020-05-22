class Rectangle extends JPanel {

    Random random1 = new Random(1000);

    private java.awt.Rectangle[] rects;

    public Rectangle() {
        rects = new java.awt.Rectangle[2];
        for(int i=0; i<2; i++ ){
            int x1 = random1.nextInt(1000);
            int x2 = random1.nextInt(700);
            int x3 = random1.nextInt(600);
            int x4 = random1.nextInt(400);
            rects[i] = new java.awt.Rectangle(x1, x2, x3, x4);
        }
    }

    protected void paintComponent(Graphics g) 
    {
        super.paintComponent(g); 
        g.setColor(Color.red);

        Graphics2D g2d = (Graphics2D)g;
        for(java.awt.Rectangle rect : rects){
            g2d.fill(rect);
        }
    }
}