package com.company;

import java.util.Scanner;

class Coordinate {
    private final int col, row;

    public Coordinate(int col, int row) {
        this.col = col;
        this.row = row;
    }

    @Override
    public String toString() {
        return "Coordinate{" +
                "col=" + col +
                ", row=" + row +
                '}';
    }
}


public class Main {
    private final Scanner input;

    public static void main(String[] args) {
        Main m = new Main();
        System.out.println(m.readCoordinate());
    }

    Main() {
        input = new Scanner(System.in);
    }

    private Coordinate readCoordinate() {
        System.out.println("Provide a coordinate:");

        while (true) {
            String line = input.nextLine();
            Coordinate c = parseCoordinate(line);

            if (c != null)
                return c;

            System.out.println("That is not a valid coordinate! Try again.");
        }
    }

    /**
     * Converts a string like A2 into a Coordinate object. Returns null if string is invalid.
     */
    public Coordinate parseCoordinate(String line) {
        line = line.trim().toLowerCase();

        if (line.length() != 2)
            return null;

        char letter = line.charAt(0);

        if (letter > 'h' || letter < 'a')
            return null;
        int col = letter - 'a' + 1;

        char number = line.charAt(1);
        if (number > '8' || number < '1')
            return null;
        int row = number - '1' + 1;

        return new Coordinate(col, row);
    }
}