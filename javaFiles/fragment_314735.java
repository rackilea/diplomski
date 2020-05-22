import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.JOptionPane;

public class MainClass {

    private final Point coordinates = new Point(0, 0);
    private final int MAX_POINTS = 3;
    private final ArrayList<Point> coordinateList = new ArrayList<Point>();

    public void inputCoordinates() {

        String tempString;
        int tempx = 0;
        int tempy = 0;

        for (int i = 0; i < this.MAX_POINTS; i++) {
            try {
                tempString = JOptionPane.showInputDialog(null, "Enter X coordinate:");
                tempx = Integer.parseInt(tempString);
                tempString = JOptionPane.showInputDialog(null, "Enter Y coordinate:");
                tempy = Integer.parseInt(tempString);
                this.coordinates.setLocation(tempx, tempy);// set input data into
                this.coordinateList.add(this.coordinates.getLocation()); // put in
            }
            catch (final NumberFormatException e) {
                System.err.println("ERROR!");
                main(null);

            }
        }
    }

    public void displayPoints() {

        for (int i = 0; i < this.MAX_POINTS; i++) {

            JOptionPane.showMessageDialog(null, "Point number " + (i + 1) + " is: " + this.coordinateList.get(i));

        }

    }

    /**
     * This sorts the points by the X coordinates
     */
    public void sortByXCoordinates() {

        Collections.sort(this.coordinateList, new PointCompare());

    }

    public class PointCompare
        implements Comparator<Point> {

        public int compare(final Point a, final Point b) {
            if (a.x < b.x) {
                return -1;
            }
            else if (a.x > b.x) {
                return 1;
            }
            else {
                return 0;
            }
        }
    }

    public static void main(final String[] args) {
        final MainClass main = new MainClass();

        main.inputCoordinates();
        main.displayPoints();

    }
}