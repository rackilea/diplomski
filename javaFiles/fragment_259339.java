public ImageIcon resizeIcon(int width, int height, ImageIcon icon) {
   Image img = icon.getImage();
   Image newimg = img.getScaledInstance(width, height, java.awt.Image.SCALE_SMOOTH);
   icon = new ImageIcon(newimg);  
   return icon;
}