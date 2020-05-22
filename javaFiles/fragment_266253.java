BufferedImage img = new BufferedImage(getWidth(), getHeight(), BufferedImage.TYPE_3BYTE_BGR);
Graphics2D imgGraphics2D = img.createGraphics();
imgGraphics2D.setColor(Color.white);
imgGraphics2D.fillRect(0, 0, getWidth(), getHeight());
imgGraphics2D.dispose();

byte[] pixels = ((DataBufferByte) img.getRaster().getDataBuffer()).getData();
for(int j=0; j < sizew; j++)
{
    for(int k=0; k < sizeh; k++)
    {
        if(data[j][k] > minimumValueToPlot)
        {
            int x = (int)(xscale * j);
            int y = (int)(yscale * k);
            int pixelindex = (y * getWidth() + x) * 3;
            pixels[pixelindex + 1] = 255; // set the green byte
        }
    }
}

g2.setComposite(AlphaComposite.Src);
g2.drawImage(img, 0, 0, null);