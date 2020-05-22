public class ButtonPainter implements Painter {

    private Color light, dark;
    private GradientPaint gradPaint;

    public ButtonPainter(Color light, Color dark) {
        this.light = light;
        this.dark = dark;
    }

    @Override
    public void paint(Graphics2D g, Object c, int w, int h) {
        System.out.println("...");
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        gradPaint = new GradientPaint((w / 2.0f), 0, light, (w / 2.0f), (h / 2.0f), dark, true);
        g.setPaint(gradPaint);
        g.fillRect(2, 2, (w - 5), (h - 5));

        Color outline = new Color(0, 85, 0);
        g.setColor(outline);
        g.drawRect(2, 2, (w - 5), (h - 5));
        Color trans = new Color(outline.getRed(), outline.getGreen(), outline.getBlue(), 100);
        g.setColor(trans);
        g.drawRect(1, 1, (w - 3), (h - 3));
    }
}