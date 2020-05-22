package com.example;

import java.util.Scanner;
import java.util.Set;
import static java.lang.System.out;

public class ScannerTest {
    int p = 0;
    String name = "Test";

    public void startGame() {
        out.println("Player1: 1 for dumb player, 2 for smart player, 3 for human player.");
        Scanner scan = new Scanner(System.in);
        p = scan.nextInt();

        out.println("Result1: " + p);

        out.println("Player2: 1 for dumb player, 2 for smart player, 3 for human player.");
        p = scan.nextInt();

        out.println("Result2: " + p);

        // scan.close();   // Do not close the Scanner to leave System.in open
    }

    public int findBestMove(Set<Integer> moves, Object /*Board*/ b) {
        out.println("Player " +name+ ", select a column from 1-7: ");
        Scanner scan = new Scanner(System.in);
        int move = scan.nextInt();
        // scan.close();   // Do not close the Scanner to leave System.in open

        out.println("Move: " + move);

        return 0;
    }

    public void run() {
        startGame();
        findBestMove(null, null);
    }

    public static void main(String[] args) {
        ScannerTest st = new ScannerTest();
        st.run();
    }
}