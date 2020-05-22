public class SpriteField extends JPanel {
    final List<RoundSprite> sprites = new ArrayList<>();

    public void CreateSpriteAt(float tX, float tY, int tWidth, int tHeight, int tRotation) {
        RoundSprite s = new RoundSprite();
        s.SetPosition(tX, tY);
        s.SetSpriteWidth(tWidth);
        s.SetSpriteHeight(tHeight);
        s.SetSpriteRotation(tRotation);
        sprites.add(s);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        AffineTransform originalTransform = g2.getTransform();

        for (RoundSprite s : sprites) {
            s.DrawSprite(g2);
            g2.setTransform(originalTransform);
        }
    }
}