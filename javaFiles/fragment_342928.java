private BufferedImage sample; //declare as class member to reuse instance

@Override
protected void paintComponent(Graphics g) {
    if (sample == null) { // lazy initialization, but you could do it even in constructor
        sample = new BufferedImage(sampleWidth, sampleHeight, bufferedImage.TYPE_INT_ARGB);
        Graphics2D g2d = sample.createGraphics();
        g2d.setColor(Color.WHITE);
        g2d.fillRect(0, 0, sampleWidth, sampleHeight);
        g2d.setColor(Color.BLACK);
        g2d.drawString("Some text", 10, 10);
        g2d.drawWhateverYouNeed(....);
    }

    g.setColor(getBackground());
    g.fillRect(0, 0, getWidth(), getHeight());
    // draw sample image three times, in sequence
    for (int i = 0; i < 3; i++) { 
        g.drawImage(sample, 0, i * sampleHeight, this);
    }
}