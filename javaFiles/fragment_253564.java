public class DrawTest extends JPanel{
    public static void main(String[] args)
    {

        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DrawTest());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public Dimension getPreferredSize(){
        return new Dimension(400,300);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.setColor(Color.black);
        g.drawLine(10, 10, 100, 10);
        g.setColor(getBackground());
        g.drawLine(50, 10, 60, 10);
    }
}