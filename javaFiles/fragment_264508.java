public class MaxSizeUI
{
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MaxSizeUI().makeUI();
            }
        });
    }

    public void makeUI() {
        final JFrame frame = new JFrame("Sample Fram") {

            @Override
            public void paint(Graphics g) {
                Dimension d = getSize();
                Dimension m = getMaximumSize();
                boolean resize = d.width > m.width || d.height > m.height;
                d.width = Math.min(m.width, d.width);
                d.height = Math.min(m.height, d.height);
                if (resize) {
                    Point p = getLocation();
                    setVisible(false);
                    setSize(d);
                    setLocation(p);
                    setVisible(true);
                }
                super.paint(g);
            }
        };
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setMaximumSize(new Dimension(400, 200));
        frame.setMinimumSize(new Dimension(200, 100));
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}