Graphics2D g2 = (Graphics2D) g;
     RenderingHints qualityHints = new RenderingHints(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON );
        qualityHints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY );
        g2.setRenderingHints( qualityHints );         


     g2.setPaint(Color.RED);

     double x = 50;
     double y = 50;
     double w = x + 250;
     double h = y + 100;
     g2.fill(new RoundRectangle2D.Double(x, y, w, h, 50, 50));

     g2.fill(new Rectangle2D.Double(x + 100,y,w,h));