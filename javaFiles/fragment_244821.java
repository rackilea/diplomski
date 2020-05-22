public class TestPaintImage {

    public static void main(String[] args) {
        new TestPaintImage();
    }

    public TestPaintImage() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException ex) {
                } catch (InstantiationException ex) {
                } catch (IllegalAccessException ex) {
                } catch (UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class ImagePane extends JPanel {

        public ImagePane() {
            setLayout(new BorderLayout());
            ImageIcon icon = null;
            try {
                icon = new ImageIcon(ImageIO.read(new File("/path/to/your/image")));
            } catch (Exception e) {
                e.printStackTrace();
            }
            add(new JLabel(icon));
        }

    }
}