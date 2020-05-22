public class Test {

    public static void main(String[] args) {
        new Test();
    }

    private JLabel label;
    private String[] anArray = {
        "<html><font color=green>- spO2:91  pr:65</font></html>",
        "<html><font color=red>+ spO2:85  pr:77</font></html>",
        "<html><font color=green>- spO2:90  pr:68</font></html>",
        "<html><font color=orange>+ spO2:89  pr:76</font></html>",
        "<html><font color=orange>- spO2:89  pr:72</font></html>",
        "<html><font color=orange>+ spO2:88  pr:73</font></html>",
        "<html><font color=red>- spO2:87  pr:78</font></html>",
        "<html><font color=red>+ spO2:86  pr:73</font></html>",
        "<html><font color=green>- spO2:92  pr:74</font></html>",
        "<html><font color=green>+ spO2:90  pr:71</font></html>"
    };
    private Random randomno = new Random();

    public Test() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    ex.printStackTrace();
                }

                JFrame frame = new JFrame("Testing");
                frame.setUndecorated(true);
                frame.setAlwaysOnTop(true);
                // Transparent window...
                frame.setBackground(new Color(255, 255, 255, 0));
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                BackgroundPane pane = new BackgroundPane();
                // Set this to 0.0f to make it fully transparent
                pane.setAlpha(0.5f);
                pane.setLayout(new BorderLayout());

                pane.setBorder(new EmptyBorder(10, 10, 10, 10));

                frame.setContentPane(pane);

                label = new JLabel("Loading...");
                label.setFont(new Font("Tahoma", Font.BOLD, 28));
                label.setForeground(Color.GREEN);
                frame.add(label);

                frame.pack();
                Dimension size = frame.getSize();
                size.width = 400;
                frame.setSize(size);
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);

                Timer timer = new Timer(200, new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        label.setText(anArray[randomno.nextInt(9 - 1) + 1]);
//                      label.getParent().repaint();
                    }
                });
                timer.start();
            }
        });
    }

    public class BackgroundPane extends JPanel {

        private float alpha;

        public BackgroundPane() {
            setOpaque(false);
        }

        public void setAlpha(float alpha) {
            this.alpha = alpha;
            repaint();
        }

        public float getAlpha() {
            return alpha;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.setColor(getBackground());
            g2d.setComposite(AlphaComposite.SrcOver.derive(getAlpha()));
            g2d.fillRect(0, 0, getWidth(), getHeight());
            g2d.dispose();
        }

    }

}