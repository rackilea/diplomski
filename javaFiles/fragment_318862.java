JFrame frame = new JFrame();
ComponentResizer cr = new ComponentResizer();
cr.registerComponent(frame);
cr.setSnapSize(new Dimension(10, 10));
cr.setMaximumSize(new Dimension(...));
cr.setMinimumSize(new Dimension(...));