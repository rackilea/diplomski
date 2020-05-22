g2.setColor(Color.magenta);

    for (int i=0; i<n; i++)
    {
      grafika.drawLine(getWidth() * i / n   , getHeight()-(int)((2*getHeight()/ 3)/(f2/(f2-1.*i/n))), getWidth() * i /n,   getHeight() );
    }