BufferedImage ycb =  new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);

int val = (y<<16) | (cb<<8) | cr;
    ycb.setRGB(i,j,val);

ImageIO.write(ycb,"png", new File("E:\\Rose\\ycbcr\\ycbcr.png"));