/**
 * 
 * @param g1
 * @param x
 * @param y
 * @param size
 * @param str
 */
private void drawString(Graphics g1, int x, int y, int size, String str) {
    Graphics2D g = (Graphics2D) g1.create();
    g.setFont(new Font("Times New Roman", Font.PLAIN, size));
    g.drawString(str, x, y);

}