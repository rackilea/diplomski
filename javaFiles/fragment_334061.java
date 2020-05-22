public class MyPanel extends JPanel {

    @Override
    public void paintComponent(Graphics g)   {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.RED);
        g2d.fillRect(0, 0, getWidth(), getHeight());
    }


    public static void main(String[] args){
        JFrame frame = new JFrame("My frame");
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        //Button Panel
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(new JButton("Click me!"));

        //Drawing panel
        MyPanel panel = new MyPanel();
        frame.add(panel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }
}