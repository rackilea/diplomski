PdfTemplate tp=cb.createTemplate(width,height);
Graphics2D g2D=new PdfGraphics2D(cb,width,height);
Rectangle2D r2D=new Rectangle2D.Double(0,0,width,height);
Chart.getInstance().getChart().draw(g2D,r2D);
g2D.dispose();
cb.addTemplate(tp, 0, 0);