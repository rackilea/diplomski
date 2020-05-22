import java.util.ArrayList;

public abstract class AbstractCurve extends ArrayList<Point> {

    public AbstractCurve(int np, double m, double b, int dx) {
        for (int i = 0; i < np; i++) {
            int x = i * dx;
            double y = m * x + b;
            if (y < 0) {
                throw new IllegalArgumentException();
            }
            this.add(new Point(x, y));
        }
    }
}