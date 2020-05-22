public class CircleCanvasFrame extends JFrame implements ActionListener {
    private JPanel circlePanel = new JPanel();

    public CircleCanvasFrame() {
        setVisible(true);
        setSize(400, 400);
        circlePanel.setLayout(new BoxLayout(circlePanel, BoxLayout.Y_AXIS));
        JButton button = new JButton("add a circle canvas");
        button.addActionListener(this);
        add(button, BorderLayout.NORTH);
        add(circlePanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new CircleCanvasFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        circlePanel.add(new MyCircleCanvas());
        pack();
    }
}