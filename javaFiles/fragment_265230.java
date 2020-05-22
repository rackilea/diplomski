public class XButton extends JButton {

    public XButton() {
        super();
    }

    public void paintComponent(Graphics g){
        Graphics2D g2d = (Graphics2D)g;         
        GradientPaint gp = new GradientPaint(0, 0, Color.RED, 30, 30, Color.cyan, true);                
        g2d.setPaint(gp);
        g2d.fillRect(0, 0, this.getWidth(), this.getHeight()); 
    }
}