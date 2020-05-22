public class ImagePanel extends JPanel {

  private Image img;

  public void setImage(String img) {
    setImage(new ImageIcon(img).getImage());
  }

  public void setImage(Image img) {
    int width = this.getWidth();
    int height = (int) (((double) img.getHeight(null) / img.getWidth(null)) * width);
    this.img = img.getScaledInstance(width, height, Image.SCALE_SMOOTH);
  }

  @Override
  public void paintComponent(Graphics g) {
    g.drawImage(img, 0, 0, this);
  }
}