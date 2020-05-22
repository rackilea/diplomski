public Timer drawThread() {
    return new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            addShape();
            repaint();
        }
    });
}