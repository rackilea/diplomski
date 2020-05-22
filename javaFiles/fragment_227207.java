public class CatchMeV2 {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setTitle("CatchMe.V2");
        RedSquare r = new RedSquare();
        frame.setContentPane(r);
        frame.setVisible(true);
    }
}

class RedSquare extends JPanel implements ActionListener {

    public RedSquare() {

    }

    @Override    
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // don't forget to call super method
        g.setColor(Color.green);
        g.fillRect(20, 20, 50, 50);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}