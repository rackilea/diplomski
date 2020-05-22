import java.io.IOException;

import java.util.Scanner;

public class MyGradeLoops {
public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    for (int x = 1; x <= 5; x++) {
        System.out.println("Please enter Your Class Grades");
        String A;
        char B;
        A = in.next();
        System.out.println("Thank You");
        if (A.length() != 1) {
            System.out.println("Only One Letter At A Time");
        }
    }
    System.out.println("Keep Up The Good Work");
}
}