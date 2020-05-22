public class ShadowButton {
    public static void main(String... args) {
        SwingUtilities.invokeLater(ShadowButton::new);
    }

    public ShadowButton() {
        var fadeWidth = 30;
        var p = new JPanel();
        var b = new JButton("with fading out border!!!") {
            @Override
            public void paintBorder(Graphics g) {
                var rec = g.getClip().getBounds();
                var c = this.getBackground();
                var d = this.getParent().getBackground();
                for (int i = 0; i < fadeWidth; i++) {
                    var col = mixColor(c, d, 1.0 * (i + 1) / fadeWidth);
                    g.setColor(col);
                    g.drawRect(rec.x + i, rec.y + i, rec.width - 2 * i, rec.height - 2 * i);
                }
            }
        };
        b.setFocusable(false);
        b.setBackground(Color.GREEN);
        b.setForeground(Color.BLACK);
        Font f = new Font("Arial", Font.BOLD, 36);
        b.setFont(f);
        b.setBorder(BorderFactory.createLineBorder(b.getBackground(), fadeWidth, false));
        p.setBackground(Color.RED);
        p.add(b);
        var frame = new JFrame("Shadoe Demo");
        frame.setContentPane(p);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private static Color mixColor(Color c, Color d, double factor) {
        float[] cc = c.getComponents(null);
        float[] dd = d.getComponents(null);
        float[] result = new float[cc.length];
        for (int i = 0; i < 4; i++) {
            result[i] = (float) (factor * cc[i] + (1 - factor) * dd[i]);
        }
        return new Color(result[0], result[1], result[2], result[3]);
    }
}