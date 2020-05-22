public static void main(String[] args){
   JFrame frame = new JFrame();
   DrawPanel drawPanel = new DrawPanel();
   drawPanel.add(new BrushStroke());
   frame.getContentPane().add(drawPanel);
   frame.pack();
   frame.setVisible(true);
}
class DrawPanel extends JPanel{
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setPaint(Color.black);
        g2.fillRect(0, 0, getWidth(), getHeight());
    }
    @Override
    public  Dimension getPreferredSize(){
        return new Dimension(100, 100);
    }
}
class BrushStroke extends JPanel{
    public void paintComponent(Graphics g){
        this.setOpaque(false);
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Color.red);
        g2.fillOval(0, 0, 10, 10); 
    }
    @Override
    public  Dimension getPreferredSize(){
        return new Dimension(10, 10);
    }
}