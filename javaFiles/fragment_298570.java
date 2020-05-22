public void stateChanged(ChangeEvent e) 
{

for (int x = 0; x < image.getWidth(); x++) {
    for (int y = 0; y < image.getHeight(); y++) 
        {
        Color color = new Color(image.getRGB(x, y));

        int r, g, b;
        val = sliderBrightness.getValue();

        r = checkColorRange(color.getRed() + val);
        g = checkColorRange(color.getGreen() + val);
        b = checkColorRange(color.getBlue() + val);

        color = new Color(r, g, b);
        image.setRGB(x, y, color.getRGB());
        border.setIcon(new ImageIcon(image.getScaledInstance(350, 350, Image.SCALE_SMOOTH)));
        border.repaint();
        }
    }
}
public int checkColorRange(int newColor){
    if(newColor > 255){
        newColor = 255;
    } else if (newColor < 0) {
        newColor = 0;
    }
    return newColor;
}