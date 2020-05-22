package com.stackoverflow.q15134193;

public class Test1 {
    public static Arr[][] points;
    static float getFloat = 1;
    static boolean getBoolean = true;
    static String getText = "hi";

    public static void main(String[] args) {

        points = new Arr[100][];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Arr[100];
            for (int j = 0; j < points[i].length; j++)
                points[i][j] = new Arr();
        }

        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points[i].length; j++) {
                points[i][j].pointX = getFloat;
                points[i][j].pointY = getFloat;
                points[i][j].yesNo = getBoolean;
                points[i][j].text = getText;
            }
        }

        for (int i = 0; i < points.length; i++)
            for (int j = 0; j < points[i].length; j++)
                System.out.println("X: " + points[i][j].pointX + " Y: " 
                        + points[i][j].pointY + " YesNo: " 
                        + points[i][j].yesNo 
                        + " text: "+ points[i][j].text);
    }
}

class Arr {
    public float pointX;
    public float pointY;
    public boolean yesNo;
    public String text;
}