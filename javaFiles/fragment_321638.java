long tm=System.currentTimeMillis();
int i;
Toolkit it=Toolkit.getDefaultToolkit();
  Dimension d=it.getScreenSize();
  int w=(int)d.getWidth(), h=(int)d.getHeight();
  Rectangle rect=new Rectangle(0, 0, w, h);
  Robot r=null;
  try {
    r=new Robot();
  }
  catch(AWTException awte){ };
  BufferedImage ib=r.createScreenCapture(rect);
  int[] pix=ib.getRGB(0, 0, w, h, null, 0, w);
  for(i=0; i<pix.length; i++) pix[i]=pix[i]&0x00ffffff;
      System.out.println("t1 "+(System.currentTimeMillis()-tm));
       tm=System.currentTimeMillis();
  for(i=0; i<pix.length; i++) r.getPixelColor(i%w, i/w);
      System.out.println("t2 "+(System.currentTimeMillis()-tm));