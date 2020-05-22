public class Test {
    public class MyPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            // code here
        }
    }
    JPanel panel = new MyPanel();
    panel.repaint();
}