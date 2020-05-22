import java.util.ArrayList;

import processing.core.PApplet;


public class Processing extends PApplet {
    ArrayList<Integer> test = new ArrayList<Integer>();

    int x = 100;
    int y = 100;

    public void setup() {
        size(640, 600);
        background(255);
        test.add(10);
        test.add(20);
        test.add(30);
        noLoop();
    }

    public void draw() {
        for (int testing : test) {
            printTask(x + testing, y);
        }
    }

    public void printTask(int x, int y) {
        rect(x, y, 10, 10);
    }

    static public void main(String args[]) {
        PApplet.main(new String[] { "--bgcolor=#ECE9D8", "Processing" });

}