g2.setColor(Color.black);

    for (int i=n-1; i>-1; i--)
    {
      grafika.drawLine(getWidth() * (n-i) / n   , getHeight()-(int)((2*getHeight()/ 3)/(f/(f-1.*i/n))), getWidth() * (n-i) /n,  getHeight()  );
    }