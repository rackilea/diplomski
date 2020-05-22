p1label.setIcon(p1icon);
    p2label.setIcon(p2icon);
    p3label.setIcon(p3icon);
    p4label.setIcon(p4icon);

    MouseMotionListener mouseAction = new MouseMotionAdapter() {

        @Override
        public void mouseDragged(MouseEvent e) {
            JComponent label = (JComponent) e.getSource();
            label.setLocation(label.getLocation().x + e.getX(), label.getLocation().y + e.getY());
        }
    };

    p1label.addMouseMotionListener(mouseAction);
    p2label.addMouseMotionListener(mouseAction);
    p3label.addMouseMotionListener(mouseAction);
    p4label.addMouseMotionListener(mouseAction);