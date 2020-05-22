setMinimumSize(new Dimension(200, Integer.MAX_VALUE));
    addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent e) {
            Dimension size = getSize();
            size.width = 200;
            setSize(size);
        }
    });