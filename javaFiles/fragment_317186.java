giraffewindow.add(status);

    giraffewindow.addMouseMotionListener(new MouseMotionListener() {

        @Override
        public void mouseMoved(MouseEvent evt) {
            status.setBounds(evt.getX(), evt.getY(), labelWidth,
                    labelHeight);
        }

        @Override
        public void mouseDragged(MouseEvent arg0) {}
    });