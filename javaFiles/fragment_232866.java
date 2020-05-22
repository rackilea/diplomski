import java.awt.Color;

public class QuickTester {

    public static void main(String[] args) {

        System.out.println(getColor(100).toString());
        System.out.println(getColor(75).toString());
        System.out.println(getColor(50).toString());
        System.out.println(getColor(25).toString());
        System.out.println(getColor(0).toString());
    }

    private static Color getColor(double currHp) {

        int green = ((int) (currHp / 100.0 * 255));
        int red = 255 - green;

        return new Color(red, green, 0);
    }
}