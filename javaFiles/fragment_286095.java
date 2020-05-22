public class TestJLayerZoom {

    public static void main(String args[]) {
        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = new JFrame();
                frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

                final JPanel panel = new JPanel();
                final ZoomUI layerUI = new ZoomUI();
                final JLayer<JComponent> jLayer = new JLayer<JComponent>(panel, layerUI);

                JButton zoomIn = new JButton("Zoom In");
                zoomIn.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        layerUI.zoom += 0.1;
                        jLayer.repaint();
                    }
                });
                panel.add(zoomIn);

                JButton zoomOut = new JButton("Zoom Out");
                zoomOut.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        layerUI.zoom -= 0.1;
                        jLayer.repaint();
                    }
                });
                panel.add(zoomOut);

                frame.setPreferredSize(new Dimension(400, 200));
                frame.add(jLayer);
                frame.pack();
                frame.setVisible(true);
            }
        });
    }

    private static class ZoomUI extends LayerUI<JComponent> {

        public double zoom = 2; // Changing this value seems to have no effect

        @Override
        public void paint(Graphics g, JComponent c) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.scale(zoom, zoom);
            super.paint(g2, c);
            g2.dispose();
        }

        @Override
        public void installUI(JComponent c) {
            super.installUI(c);
            JLayer jlayer = (JLayer) c;
            jlayer.setLayerEventMask(
                    AWTEvent.MOUSE_EVENT_MASK | AWTEvent.ACTION_EVENT_MASK
                    | AWTEvent.MOUSE_MOTION_EVENT_MASK
            );
        }

        @Override
        public void uninstallUI(JComponent c) {
            JLayer jlayer = (JLayer) c;
            jlayer.setLayerEventMask(0);
            super.uninstallUI(c);
        }
    }
}