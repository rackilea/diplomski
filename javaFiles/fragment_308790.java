ArrayList<Point> list = new ArrayList<Point>();
    BufferedImage bi= ImageIO.read(img); //Reads in the image

    //Color you are searching for
    int color= 0xFF00FF00; //Green in this example
    for (int x=0;x<width;x++)
        for (int y=0;y<height;y++)
            if(bi.getRGB(x,y)==color)
                list.add(new Point(x,y));