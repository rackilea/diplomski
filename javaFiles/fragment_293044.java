class HistogramCtrl extends JComponent
{
    BufferedImage m_image;
    int[] m_histogramArray = new int[256];  //What drives our histogram
    int m_maximumPixels;
    public HistogramCtrl(){
        m_maximumPixels = 0;
        for(short i = 0; i<256; i++){
            m_histogramArray[i] = 0;
        }
    }

    void setImage(BufferedImage image){
        m_image = image;
        updateHistogram();
        repaint();
    }

    void updateHistogram(){
        if(m_image == null) return;

        int[] pixels = m_image.getRGB(0, 0, m_image.getWidth(), m_image.getHeight(), null, 0, m_image.getWidth());
        short currentValue = 0;
        int red,green,blue;
        for(int i = 0; i<pixels.length; i++){           
                red = (pixels[i] >> 16) & 0x000000FF;
                green = (pixels[i] >>8 ) & 0x000000FF;
                blue = pixels[i] & 0x000000FF;
                currentValue = (short)((red + green + blue) / 3); //Current value gives the average //Disregard the alpha
                assert(currentValue >= 0 && currentValue <= 255);   //Something is awfully wrong if this goes off...
                m_histogramArray[currentValue] += 1;    //Increment the specific value of the array
        }

        m_maximumPixels = 0;    //We need to have their number in order to scale the histogram properly
        for(int i = 0; i < m_histogramArray.length;i++){    //Loop through the elements
            if(m_histogramArray[i] > m_maximumPixels){  //And find the bigges value
                m_maximumPixels = m_histogramArray[i];
            }
        }
    }

    protected void paintComponent(Graphics g){
        assert(m_maximumPixels != 0);

        Rectangle rect = g.getClipBounds();

        Color oldColor = g.getColor();
        g.setColor(new Color(210,210,210));
        g.fillRect((int)rect.getX(), (int)rect.getY(), (int)rect.getWidth(), (int)rect.getHeight());
        g.setColor(oldColor);

        String zero = "0";
        String thff = "255";

        final short ctrlWidth = (short)rect.getWidth();
        final short ctrlHeight = (short)rect.getHeight();

        final short activeWidth = 256;
        final short activeHeight = 200;

        final short widthSpacing = (short)((ctrlWidth - activeWidth)/2);
        final short heightSpacing = (short)((ctrlHeight - activeHeight)/2);

        Point startingPoint = new Point();
        final int substraction = -1;
        startingPoint.x = widthSpacing-substraction;
        startingPoint.y = heightSpacing+activeHeight-substraction;

        g.drawString(zero,widthSpacing-substraction - 2,heightSpacing+activeHeight-substraction + 15);
        g.drawString(thff,widthSpacing+activeWidth-substraction-12,heightSpacing+activeHeight-substraction + 15);

        g.drawLine(startingPoint.x, startingPoint.y, widthSpacing+activeWidth-substraction, heightSpacing+activeHeight-substraction);
        g.drawLine(startingPoint.x,startingPoint.y,startingPoint.x,heightSpacing-substraction);

        double factorHeight = (double)activeHeight / m_maximumPixels;   //The height divided by the number of pixels is the factor of multiplication for the other dots

        Point usingPoint = new Point(startingPoint.x,startingPoint.y);

        usingPoint.x+=2;    //I want to move this two points in order to be able to draw the pixels with value 0 a bit away from the limit
        Point tempPoint = new Point();
        for(short i = 0; i<256; i++){
            tempPoint.x = usingPoint.x;
            tempPoint.y = (int)((heightSpacing+activeHeight-substraction) - (m_histogramArray[i] * factorHeight));
            if((i!=0 && (i % 20 == 0)) || i == 255){
                oldColor = g.getColor();
                g.setColor(oldColor.brighter());
                //Draw horizontal ruler sections
                tempPoint.x = widthSpacing + i;
                tempPoint.y = heightSpacing+activeHeight-substraction+4;
                g.drawLine(tempPoint.x,tempPoint.y,widthSpacing + i,heightSpacing+activeHeight-substraction-4);

                if(i <= 200){
                    //Draw vertical ruler sections
                    tempPoint.x = widthSpacing - substraction - 3;
                    tempPoint.y = heightSpacing+activeHeight-substraction-i;
                    g.drawLine(tempPoint.x,tempPoint.y,widthSpacing - substraction + 4, heightSpacing+activeHeight-substraction-i);
                }
                tempPoint.x = usingPoint.x;
                tempPoint.y = usingPoint.y;

                g.setColor(oldColor);
            }
            g.drawLine(usingPoint.x, usingPoint.y, tempPoint.x, tempPoint.y);
            usingPoint.x++; //Set this to the next point
        }
    }
}