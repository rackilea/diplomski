public class MyPanel extends JPanel {

    public MyPanel() {
        super(new GridLayout(4, 4));
        for (int i = 0; i < 16; i++) {
            JPanel panel = new JPanel(new GridLayout());
            panel.add(new CenterLabel());
            this.add(panel);
        }
    }

    private static void create() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.add(new MyPanel());
        f.pack();
        f.setVisible(true);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                create();
            }
        });
    }

    private static class CenterLabel extends JLabel {

        public CenterLabel() {
            this.setHorizontalAlignment(JLabel.CENTER);
            this.setVerticalAlignment(JLabel.CENTER);
            this.setOpaque(true);
            this.setBackground(Color.lightGray);
            this.setBorder(BorderFactory.createLineBorder(Color.blue));
            this.setPreferredSize(new Dimension(160, 100));
            this.addComponentListener(new ComponentAdapter() {

                @Override
                public void componentResized(ComponentEvent e) {
                    int w = e.getComponent().getWidth();
                    int h = e.getComponent().getHeight();
                    CenterLabel.this.setText("[" + w/2 + "\u253C" + h/2 + "]");
                }
            });
        }
    }
}