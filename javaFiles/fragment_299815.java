import java.lang.Math;

public class MathTest{
    private double xone, xtwo, yone, ytwo, x1, x2, y1, y2;
    private double distance;

    public static void main(String[] args) {

    }

    public MathTest() {
        setNums();
    }

    public void setDistance() {
        setNums();
    }

    public void setNums() {
        xone = x1;
        xtwo = x2;
        yone = y1;
        ytwo = y2;
    }

    public void calcDistance() {
        distance = Math.sqrt((xtwo - xone) * (xtwo - xone) + (ytwo - yone) * (ytwo - yone));
    }

    public String toString() {
        String output = " ";
        output += "the distance is " + distance;
        return output;
    }
}