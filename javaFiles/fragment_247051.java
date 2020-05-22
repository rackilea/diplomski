g2.setColor(Color.green);

    for (int i=0; i<n; i++)
    {
        grafika.drawLine(getWidth() * i / n   , 0, getWidth() * i /n,   (int)((getHeight()/ 3)/(f2/(f2-1.*i/n))) );
    }