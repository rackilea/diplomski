/**
 * alter the image´s contrast and brightness
 * @throws IOException
 */
public void alterImage() throws IOException {
    imageAltered = new BufferedImage(imageOriginal.getWidth(), imageOriginal.getHeight(), BufferedImage.TYPE_INT_RGB);
    brightness = rand.nextInt(150 + 200 + 1) - 200; //values from 150 to 200
    contrast = 1.5 + (5.0 - 1.5) * rand.nextDouble(); //values from 1.5 to 5.0

    for(int i = 0; i < imageOriginal.getWidth(); i++) {
        for(int j = 0; j < imageOriginal.getHeight(); j++) {
            Color c = new Color(imageOriginal.getRGB(i, j));
            int red = (int) contrast * c.getRed() + brightness;
            int green = (int) contrast * c.getGreen() + brightness;
            int blue = (int) contrast * c.getBlue() + brightness;

            if(red > 255) { // the values of the color components must be between 0-255
                red = 255;
            } else if(red < 0) {
                red = 0;
            }
            if(green > 255) {
                green = 255;
            } else if(green < 0) {
                green = 0;
            }
            if(blue > 255) {
                blue = 255;
            } else if(blue < 0) {
                blue = 0;
            }
            imageAltered.setRGB(i, j, new Color(red, green, blue).getRGB());
        }
    }
}