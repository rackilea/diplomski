public class TestSlider {

    public static void main(String[] args) {
        new TestSlider();
    }

    public TestSlider() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Test");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }

        });
    }

    public class TestPane extends JLayeredPane {

        private JProgressBar pb;
        private JSlider slider;

        public TestPane() {

            pb = new JProgressBar();
            slider = new JSlider();

            add(pb, new Integer(0));
            add(slider, new Integer(1));

        }

        @Override
        public Dimension getPreferredSize() {
            Dimension size = pb.getPreferredSize();
            size.height *= 4;
            size.width = Math.max(size.width, slider.getPreferredSize().width);
            return size;
        }

        @Override
        public void doLayout() {
            super.doLayout();

            int width = getWidth();
            int height = getHeight();

            Dimension size = pb.getPreferredSize();

            int x = 10;
            int y = (getHeight() - size.height) / 2;

            pb.setLocation(x, y);
            size.width = getWidth() - 21;
            pb.setSize(size);

            size = slider.getPreferredSize();
            x = (getWidth() - size.width) / 2;
            y = (getHeight() - size.height) / 2;
            slider.setBounds(x, y, size.width, size.height);

        }

    }

}