import java.awt.Color;

public class QuickTest {

    public static void brighten(Color color, int d) {
        System.out.println("brighten");
        while(d > 0)
        {
            System.out.println(color);
            color = color.brighter();
            d = d-1;
        }
        System.out.println(color);
    }

    public static void main(String[] args) throws Exception {
        int d = 3;
        brighten(Color.red,3);
        brighten(new Color(45,125,0),3);
        brighten(new Color(45,125,1),3);
    }
}