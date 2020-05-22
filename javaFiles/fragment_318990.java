public interface GameElement {
    public void draw(Graphics g);
}

public class Sprite implements GameElement{
    private Image image;
    private int x;
    private int y;
    public void draw(Graphics g) {
                g.drawImage(image,x,y,null);
    }
}

public class GameLoop {

        public void drawElements(final Graphics2D g, final List<GameElement> elements) {
                for (final GameElement gameElement : elements) {
                        gameElement.draw(g);
                }
        }


}