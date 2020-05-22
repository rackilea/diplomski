public class LabelTextPos extends JLabel {

    public static void main(String args[]) {
        LabelTextPos label = new LabelTextPos();
        JFrame frame = new JFrame();
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.BLACK);
        g.drawString("Sample", 100, 100);
    }
}