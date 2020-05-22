public class MyPanel extends JPanel {
    private BufferedImage image;
    private JProgressBar progressBar = new JProgressBar();

    public MyPanel() {
        // get your image here
        add(progressBar);
    }

    public Dimension getPreferredSize() {
        Dimension size = super.getPreferredSize();;
        if (image == null) {
            return size;
        } else {
            int w = Math.max(image.getWidth(), size.width);
            int h = Math.max(image.getHeight(), size.height);
            return new Dimension(w, h);
        }
    }

    protected void paintComponent(Graphics g) {
         super.paintComponent(g); 
         if (image != null) {
            g.drawImage(image, 0, 0, null); 
         }
    }

}