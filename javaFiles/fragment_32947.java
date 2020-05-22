JFrame frame = getJFrame();
    frame.addContainerListener(new ContainerListener() {

        @Override
        public void componentAdded(ContainerEvent e) {
            frame.pack();
        }

        @Override
        public void componentRemoved(ContainerEvent e) {
        }
    });