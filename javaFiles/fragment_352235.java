public class Shapechange extends JFrame {
    public Shapechange() {
        setSize(300, 400);
        setTitle("Shape Change");
        MyPanel pane = new MyPanel(this);
        add(pane);
    }

    public static void main(String[] args) {
        Shapechange s = new Shapechange();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        s.setVisible(true);
    }
}

class MyPanel extends JPanel {
    JButton button;
    public MyShape shape = new MyShape();
    private boolean b = true;

    public MyPanel(final Shapechange shapechange) {
        button = new JButton("Click");
        add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                b = !b;
                shapechange.repaint();
            }
        });
    }

    @Override
    public void paintComponent(Graphics g) {
        if (b) {
            shape.rectangledrawing(g);
        } else {
            shape.ovaldrawing(g);
        }

    }
}

class MyShape {
    public void rectangledrawing(Graphics g) {
        g.drawRect(100, 200, 250, 300);
    }

    public void ovaldrawing(Graphics g) {
        g.drawOval(100, 200, 250, 300);
    }

}