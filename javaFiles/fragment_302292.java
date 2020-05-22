/**
 * Distance calc
 * User: mduffy
 * Date: 11/1/2015
 * Time: 9:58 AM
 * @link http://stackoverflow.com/questions/33462961/trying-to-calculate-the-distance-between-the-position-of-two-objects/33463222?noredirect=1#comment54712511_33463222
 */
public class Soldier {

    public final double xPos;
    public final double yPos;

    public static void main(String[] args) {
        Soldier s = new Soldier(0, 0);
        Cavalier c = new Cavalier(3, 4);
        System.out.println(String.format("distance: %f10.3", s.distanceBetween(c)));
    }

    public Soldier(double xPos, double yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    public double distanceBetween(Soldier s) {
        return distanceBetween(this.xPos, this.yPos, s.xPos, s.yPos);
    }

    public static double distanceBetween(double x1, double y1, double x2, double y2) {
        double dx = Math.abs(x2-x1);
        double dy = Math.abs(y2-y1);
        if (dx > dy) {
            double r = dy/dx;
            return dx*Math.sqrt(1.0 + r*r);
        } else {
            double r = dx/dy;
            return dy*Math.sqrt(1.0 + r*r);
        }
    }

    public static double distanceBetween(Soldier s1, Soldier s2) {
        return distanceBetween(s1.xPos, s1.yPos, s2.xPos, s2.yPos);
    }
}

class Cavalier extends Soldier {
    public Cavalier(double x, double y) {
        super(x, y);
    }
}