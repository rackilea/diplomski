double f=2./3, f2=1-f;

    g2.setColor(Color.blue);

    for (int i=n-1; i>-1; i--)
    {
      grafika.drawLine(getWidth() * (n-i) / n, 0, getWidth() * (n-i)/n,  
        (int)((getHeight()/ 3)/(f/(f-1.*i/n))) );
    }