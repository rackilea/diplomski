public class MyTextPane extends JTextPane {

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        g2.setColor(new Color(255, 0, 0, 128));

        FontMetrics fm = g2.getFontMetrics();
        int textHeight = fm.getHeight();

        for (int i = textHeight; i < getHeight(); i += (6 * textHeight)) {
            g2.drawLine(0, i + 1, getWidth(), i + 1);
        }

        g2.dispose();
    }
}