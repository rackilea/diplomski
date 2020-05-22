import java.awt.Color;
import java.awt.Graphics;

public class Draw {

    private static final Color TAN = new Color(185, 133, 91);
    private int x;
    private int y;
    private int z;
    private int n;

    public Draw(int x, int y, int z, int n) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.n = n;
    }

    public void myPaint(Graphics g) {
        g.setColor(TAN);
        g.fillRect((x * n + 20 / z), (y * n + 20 / z), (320 / z), (320 / z));
    }
}