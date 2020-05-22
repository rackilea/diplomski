public MyPanel(){
    try {
        image = ImageIO.read(url1);
        image2 = ImageIO.read(url2);
        image3 = ImageIO.read(url3);

    } catch (IOException e) {
    }

    img = createImage();
}

private Image createImage(){

    double index = 0;

  BufferedImage bufferedImage = new BufferedImage(370,370,BufferedImage.TYPE_INT_ARGB);

  Graphics g = bufferedImage.getGraphics();

  for(index = 0; index <= scale; index = index + count){

      tx = AffineTransform.getRotateInstance(Math.toRadians(deg2), 185, 185);
      op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
      g.drawImage(op.filter(image3, null), 0, 0, null);
      deg2 = deg2 + (270.0/(scale/count));
      }

      return bufferedImage;
   }

protected void paintComponent(Graphics g){

    super.paintComponent(g);

    g.drawImage(image, 0, 0, null);     //Indicator drawing
    g.drawImage(img, 0, 0, null);       //Scale drawing


    //Indicator rotation

    tx = AffineTransform.getRotateInstance(Math.toRadians(degrees), this.getHeight()/2, this.getWidth()/2);
    op = new AffineTransformOp(tx, AffineTransformOp.TYPE_BILINEAR);
    g.drawImage(op.filter(image2, null), 0, 0, null);   
}