public static void main(String[] args) {

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
            frame.setSize(200, 200);
            frame.add(new HousePane());
            frame.setVisible(true);
            frame.setLocationRelativeTo(null);

        }
    });

}

public static class HousePane extends JPanel {

    private List<Rectangle2D> parts = new ArrayList<Rectangle2D>(25);
    private List<Rectangle2D> selected = new ArrayList<Rectangle2D>(25);

    public HousePane() {

        parts.add(new Rectangle2D.Float(10, 10, 50, 50));
        parts.add(new Rectangle2D.Float(60, 10, 50, 50));
        parts.add(new Rectangle2D.Float(10, 60, 50, 50));
        parts.add(new Rectangle2D.Float(60, 60, 50, 50));

        addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                selected.clear();
                for (Rectangle2D rect : parts) {
                    if (rect.contains(e.getPoint())) {
                        selected.add(rect);
                    }
                }

                // You could require the user to click the shape again
                // to deselect by doing something like...
                //for (Rectangle2D rect : parts) {
                //    if (rect.contains(e.getPoint())) {
                //        if (selected.contains(rect)) {
                //            selected.remove(rect);
                //        } else {
                //            selected.add(rect);
                //        }
                //    }
                //}
                repaint();
            }

        });

    }

    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLUE);
        for (Rectangle2D rect : selected) {

            g2d.fill(rect);

        }
        g2d.setColor(Color.BLACK);
        for (Rectangle2D rect : parts) {

            g2d.draw(rect);

        }

    }

}