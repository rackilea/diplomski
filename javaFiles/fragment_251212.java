package Testers;
import java.util.Scanner;

public class Squares {
    public static void main(String[] args) {
        Squares.getSquares(100);   
    }

    public static double getSquares(double b) {
        double sqrtNum = Math.sqrt(b);
        int i = 0;
        while(i < sqrtNum) {
            sqrtNum = Math.pow(i, 2);
            System.out.print(sqrtNum + " ");
            i++;
        }
    }
}