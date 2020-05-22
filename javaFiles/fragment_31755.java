public class CirclePanel extends JPanel implements ActionListener  {

    private JFrame f;
    private JButton run1, run2, reset, quit;
    private JPanel btnPanel;
    private int NUM;
    private Color c;

    public CirclePanel(){

        color1 = Color.red;
        color2 = Color.black;

        NUM = 5;

        // Setup JFrame and stuff as you were doing.

    }


    @Override
    public void paintComponent(Graphics g){

        super.paintComponent(g);

        g.translate(470, 400);

        for(int i = 0; i < NUM; i++){

            g.setColor(color1);
            g.fillOval(150, 0, 100, 100);

            g.setColor(color2);
            g.fillOval(90, 0, 30, 30);

            g.rotate(2*Math.PI/ NUM);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == run1) {
            System.out.println("Entered Action Handler");

            color1 = Color.green;

            repaint();
        }
    }

    // GETTERS and SETTERS if needed
}