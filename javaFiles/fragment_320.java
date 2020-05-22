Image im;
    java.awt.Graphics2D g2 = (java.awt.Graphics2D) im.getGraphics();
    g2.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
    g2.drawImage(0,0, im, null);
    g2.dispose();
    ImageIcon icon;