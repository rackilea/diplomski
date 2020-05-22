javaxt.io.Image image = new javaxt.io.Image(java.awt.image.BufferedImage bufferedImage);
    int width = image.getWidth();
    int height = image.getHeight();
    image.setCorners(20, 70,              //UL
                     width-70, 0,         //UR
                     width+20, height-50, //LR
                     50, height);         //LL