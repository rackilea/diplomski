SwingUtilities.invokeLater(new Runnable() {
    public void run() {
        frame.addComponentListener(new ComponentAdapter() {
            public void componentResized(ComponentEvent e) {
                System.out.println("Component Listener 1");
            }
        });
    }
});