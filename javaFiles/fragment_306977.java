public class Test {
    public static void main(String[] args) {

        JFrame frame = new JFrame("Test");

        frame.add(new TestComponent());

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static class TestComponent extends JComponent {
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(800, 600);
        }

        @Override
        protected void paintComponent(Graphics g) {
            g.setColor(Color.red);
            g.fillRect(10, 0, 600, 600);
        }
    }
}