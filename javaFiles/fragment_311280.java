import java.awt.*;
public class Main
{
    public static void main(String[] args) throws Exception
    {
        Point start = new Point(103, 105);
        Point end = new Point(203, 205);

        adjust(start, 4, true);
        adjust(end, 4, false);

        System.out.println(start);
        System.out.println(end);
    }

    public static void adjust(Point p, int snap, boolean snapLower)
    {
        int modX = p.x % snap;
        p.x = snapLower ? p.x - modX : p.x + snap - modX;

        int modY = p.y % snap;
        p.y = snapLower ? p.y - modY : p.y + snap - modY;
    }
}