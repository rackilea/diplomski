/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package point;

import com.google.gson.Gson;


/**
 *
 * @author alfred
 */
public class Point {

    private int x,y;
    public static Gson gson = new Gson();

    public Point(int x, int y) {
            this.x = x;
            this.y = y;
    }

    public static Point fromJSON(String json) {
        Point p = gson.fromJson(json, Point.class);
        return p;
    }

    @Override
    public String toString() {
        return "(" + x + "," + y + ")";
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Point fromJSON = Point.fromJSON("{\"x\":4,\"y\":8}");
        System.out.println(fromJSON);
    }
}