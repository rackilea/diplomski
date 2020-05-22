panel.addComponentListener(new ComponentAdapter() {
        @Override
        public void componentResized(ComponentEvent arg0) {
            component.setBounds(...);

        }
    });