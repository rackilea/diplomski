import java.util.Scanner;

public class EncodervOwl {

    public static int position(char c) {
        if (c < 'A' || c > 'Z') {
            throw new IllegalArgumentException("Character out of range");
        }
        return c - 'A' + 1;
    }

    public static char back(int i) {
        if (i < 1 || i > 'Z' - 'A' + 1) {
            throw new IllegalArgumentException("Character out of range");
        }
        return (char) ('A' + i - 1);
    }

    public static int[] positionSetter(String s) {
        int[] positions = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            positions[i] = position(s.charAt(i));
        }
        return positions;
    }

    public static String backtoLetters(int[] p) {
        StringBuilder s = new StringBuilder(p.length);
        for (int i = 0; i < p.length; i++) {
            s.append(back(p[i]));
        }
        return s.toString();
    }

    public static void printCode(int[] positions) {
        System.out.print("Positions: ");
        for (int i = 0; i < positions.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(positions[i]);
        }
        System.out.println();
    }

    public static int[] newPosition(int[] p) {
        int[] p2 = new int[p.length];
        for (int i = 0; i < p.length; i++) {
            if (p[i] <= 5) {
                p2[i] = p[i] * 2;
            } else if (p[i] > 5 && p[i] < 11) {
                // not reversible (6 and 9 map to 0, 7 and 10 to 1 etc)
                p2[i] = (p[i] % 3) * 5;
            } else if (p[i] > 10 && p[i] < 16) {
                p2[i] = (int) (p[i] / 4) * 8;
            } else if (p[i] > 15 && p[i] < 21) {
                // from 1..26 to 0..25
                p2[i] = (((p[i] % 10) + ((p[i] / 10) % 10)) * 10) % 26;
            } else if (p[i] > 20 && p[i] <= 27) { // U IS 21
                for(int e = 1;e < 14; e++) {
                    int factor = 0;
                    if(p[i] % e == 0) {
                        factor = e;
                    }
                    p2[i] = factor;
                }
            }
        }
        return p2;
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        for (int i = 0; i < 5; i++) {
            System.out.println("Enter any number of letters to be encoded");
            String line = scan.nextLine();
            int[] positions = positionSetter(line);
            printCode(positions);
            int[] newPositions = newPosition(positions);
            printCode(positions);
            String encodedLine = backtoLetters(newPositions);
            System.out.println(encodedLine);
        }
    }
}