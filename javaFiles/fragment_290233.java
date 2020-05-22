HashMap<int[], Rectangle2D> generateGlyphs(int fontSize, String characters, Font font){
  HashMap<int[], Rectangle2D> ret = new HashMap<int[], Rectangle>();
  FontRenderContext rendCont = new FontRenderContext(null, true, true);

  for(int i = 0; i < characters.length; i++){
    Rectangle2D bounds = font.getStringBounds(characters.substring(i, 1), rendCont);
    BufferedImage bi = new BufferedImage((int)bounds.getWidth(), (int)bounds.getHeight(), BufferedImage.TYPE_INT_GRAY);

    Graphics g = bi.getGraphcs();
    g.setFont(font);
    g.drawString(characters.substring(i, 1), 0, (int)bounds.getHeight());

   ret.put(bi.getData().getPixels(0, 0, (int)bounds.getWidth(), (int)bounds.getHeight()), bounds);
  }

  return ret;
}