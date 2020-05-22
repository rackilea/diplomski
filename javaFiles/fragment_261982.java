JLabel label = new JLabel("Click Me To Load Image");
label.addMouseListener(new MouseAdapter() {
    public void mouseClicked(MouseEvent event) {
        if (label.isEnabled()) {
            loadImage();
        }
    }
}

void loadImage() {
    SwingWorker<Image, Object> imageLoader= new SwingWorker<>() {
        public Image doInBackground() {
            // do long task and return result
        }
        public void done() {
            imageToPaint = get();
            repaint();
            label.setEnabled(true);
        }
    }
    label.setEnabled(false);
    imageLoader.execute();
}