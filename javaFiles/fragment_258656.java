public Image init( Graphics g )
    {
         bim=new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
         g=bim.getGraphics();
         g.setColor(Color.yellow);
         g.fillRect(0, 0, w, h);
         g.setColor(Color.red);
         g.fillArc(x, y, 300, 300, 270, 75);  // 2*w/16, 2*h/16 
         int[] pix=bim.getRGB(0, 0, w, h, null, 0, w);
         Vector v1=measureArea(pix, Color.red.getRGB());
         g.setColor(Color.yellow);
         g.fillRect(0, 0, w, h);
         g.setColor(Color.blue);
         g.fillArc(x+100, y+100, 150, 150, 270, 45); //2*w/32, 2*h/32,
         pix=bim.getRGB(0, 0, w, h, null, 0, w);
         Vector v2=measureArea(pix, Color.blue.getRGB());
         System.out.println( intersect(v1, v2) );
         return bim;
    }