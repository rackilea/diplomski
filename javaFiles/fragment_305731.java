static double bufferedImagesEqualConfidence(BufferedImage img1, BufferedImage img2) {
    double difference = 0;
    int pixels = img1.getWidth() * img1.getHeight(); 
    if (img1.getWidth() == img2.getWidth() && img1.getHeight() == img2.getHeight()) {
        for (int x = 0; x < img1.getWidth(); x++) {
            for (int y = 0; y < img1.getHeight(); y++) {
                int rgbA = img1.getRGB(x, y); 
                int rgbB = img2.getRGB(x, y); 
                int redA = (rgbA >> 16) & 0xff; 
                int greenA = (rgbA >> 8) & 0xff; 
                int blueA = (rgbA) & 0xff; 
                int redB = (rgbB >> 16) & 0xff; 
                int greenB = (rgbB >> 8) & 0xff; 
                int blueB = (rgbB) & 0xff;                      
                difference += Math.abs(redA - redB); 
                difference += Math.abs(greenA - greenB); 
                difference += Math.abs(blueA - blueB); 
            }
        }
    } else {
        return 0.0;
    }

    return 1-((difference/(double)pixels) / 255.0);
}