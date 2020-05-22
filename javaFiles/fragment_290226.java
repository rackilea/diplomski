@SuppressWarnings("unused")
public class TrueSprite
{
    private final int width;
    private final int height;
    private final int rows;
    private final int cols;
    private BufferedImage bigImg;
    private BufferedImage[] sprites;

    public TrueSprite(int width, int height, int rows, int columns) {
        this.width = width;
        this.height = height;
        this.rows = rows;
        this.cols = columns;
        this.bigImg = ImageIO.read(new File("robin.png"));
        this.sprites = new BufferedImage[rows * cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sprites[(i * cols) + j] = bigImg.getSubimage(j * width, i * height, width, height);    
            }
        }
    }

    public void paint(Graphics g)
    {
        g.drawImage(sprites[1], 100, 100, null);
    }
}