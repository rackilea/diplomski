frame.addComponentListener(new ComponentAdapter() {
    @Override
    public void componentResized(ComponentEvent arg0) {
        System.out.println(frame.getSize());
    }
});