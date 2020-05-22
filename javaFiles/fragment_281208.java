import java.awt.Canvas;
import java.awt.Font;
import java.awt.FontMetrics;

public class MetricsTest {

    public static void main(String[] args) {
                Font myFontTest=new Font("Arial", Font.PLAIN, 11);
                Canvas c = new Canvas();
                FontMetrics fm = c.getFontMetrics(myFontTest);
                int characterWidth=fm.charWidth('A');
                System.out.println(characterWidth);

    }

}