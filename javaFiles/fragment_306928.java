import java.awt.Toolkit;
import java.util.Random;

public class Screen extends Render {
    private Render test;

    public Screen(int width, int height) {
        super(width, height);
        int i;
        Random rand = new Random();
        test = new Render(333,333);//Toolkit.getDefaultToolkit().getScreenSize().width, Toolkit.getDefaultToolkit().getScreenSize().height);
        for (i = 0; i < 333 * 333; i++)
            test.pixels[i] = rand.nextInt();
        render();
    }

    public void render() {
        draw(test, 50, 50);
    }
}