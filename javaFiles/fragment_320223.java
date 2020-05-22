public static void main(String args[]) throws Exception {
JWindow jWindow = new JWindow() {
final Image image = ImageIO.read(<yourImage>);  // Static image only
{
    setLocation(0,0);
    setSize(image.getWidth(), image.getHeight());
}
public void paint(Graphics g) {
    g.drawImage(image, 0, 0, null);
}
};
jWindow.setVisible(true);
Thread.sleep(3000);
jWindow.setVisible(false);
}