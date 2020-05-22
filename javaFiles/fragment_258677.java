public class CharacterImageGenerator {

    private FontMetrics metrics;
    private Color color;
    private Map<Character, Image> images;

    public CharacterImageGenerator(FontMetrics metrics, Color color) {
        this.metrics = metrics;
        this.color = color;
        images = new HashMap<Character, Image>();
    }

    public Image getImage(char c) {
        if(images.containsKey(c))
            return images.get(c);

        Rectangle2D bounds = new TextLayout(Character.toString(c), metrics.getFont(), metrics.getFontRenderContext()).getOutline(null).getBounds();
        if(bounds.getWidth() == 0 || bounds.getHeight() == 0) {
            images.put(c, null);
            return null;
        }
        Image image = new BufferedImage((int)bounds.getWidth(), (int)bounds.getHeight(), BufferedImage.TYPE_4BYTE_ABGR);
        Graphics g = image.getGraphics();
        g.setColor(color);
        g.setFont(metrics.getFont());
        g.drawString(Character.toString(c), 0, (int)(bounds.getHeight() - bounds.getMaxY()));

        images.put(c, image);
        return image;
    }
}