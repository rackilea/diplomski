public class Main {

    public static void main(String[] args) {

        JFrame frame = new JFrame("frame");
        frame.setSize(400, 400);
        // frame.setLayout(new GridLayout(2, 1));
        PaintPanel paint = new PaintPanel();
        ButtonPanel buttons = new ButtonPanel(paint);
        // frame.add(paint);
        // frame.add(buttons);
        frame.setVisible(true);

        JPanel pan = new JPanel(new BorderLayout());
        pan.add(paint);
        pan.add(buttons, BorderLayout.SOUTH);
        frame.add(pan);

    }
}

class PaintPanel extends JPanel {

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(new Random().nextInt()));
        g.drawRect(10, 10, 10, 10);
    }
}

class ButtonPanel extends JPanel implements ActionListener {

    private final PaintPanel paintPanel;

    public ButtonPanel(PaintPanel paintPanel) {

        this.paintPanel = paintPanel;
        JButton button = new JButton("button");
        button.addActionListener(this);
        add(button);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if (getParent() != null) {
            getParent().repaint();
        }
    }
}