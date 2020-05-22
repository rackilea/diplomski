String path = "test.png";
  imageLbl.setIcon(null);
    try {
      BufferedImage img=ImageIO.read(new File(path));
        imageLbl.setIcon(new ImageIcon(img));
        imageLbl.revalidate();
        imageLbl.repaint();
        imageLbl.update(imageLbl.getGraphics());
    } catch (IOException ex) {

    }