private Image image = null; // holds our image

@Override
public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g;
    if (image != null) {
        // this will hardly take any time at all to run
        g2d.drawImage(image, 0, 0, this);
    }
}

public void myDrawImage() {

    // create a SwingWorker for background threading work
    new SwingWorker<Image, Void>() {

        @Override
        protected Image doInBackground() throws Exception {

            // run this long-running code within this background thread
            return device.getVisualisation();
        };

        @Override
        protected void done() {
            try {
                // when the thread is done, get the new image, 
                // put it into our image field, and repaint the component
                image = get();
                repaint();
            } catch (InterruptedException | ExecutionException e) {
                // TODO handle any exceptions that occur with drawing
            }
        };
    }.execute();
}