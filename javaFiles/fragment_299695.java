import java.io.IOException;

public class Localization {
    public static void main (String[] args) {
        short s = 0;
        while (true) {
            int next = 0;
            try {
                next = System.in.read();
            } catch (IOException e) {

            }
            if (next < '0' || next > '9') break;

            s = (short) (s * 10);
            s = (short) (s + ((short) (next - '0')));
        }

        if (s >= 100) {
            if (s >= 500) {
                if (s >= 1000) {
                    System.out.print('l');
                    System.out.print('e');
                    System.out.print('g');
                    System.out.print('i');
                    System.out.print('o');
                    System.out.print('n');
                } else {
                    System.out.print('z');
                    System.out.print('o');
                    System.out.print('u');
                    System.out.print('n');
                    System.out.print('d');
                    System.out.print('s');
                }
            } else {
                if (s >= 250) {
                    System.out.print('s');
                    System.out.print('w');
                    System.out.print('a');
                    System.out.print('r');
                    System.out.print('m');
                } else {
                    System.out.print('t');
                    System.out.print('h');
                    System.out.print('r');
                    System.out.print('o');
                    System.out.print('n');
                    System.out.print('g');
                }
            }
        } else {
            if (s >= 10) {
                if (s >= 50) {
                    System.out.print('h');
                    System.out.print('o');
                    System.out.print('r');
                    System.out.print('d');
                    System.out.print('e');
                } else if (s >= 20) {
                    System.out.print('l');
                    System.out.print('o');
                    System.out.print('t');
                    System.out.print('s');
                } else {
                    System.out.print('p');
                    System.out.print('a');
                    System.out.print('c');
                    System.out.print('k');
                }
            } else {
                if (s >= 5) {
                    System.out.print('s');
                    System.out.print('e');
                    System.out.print('v');
                    System.out.print('e');
                    System.out.print('r');
                    System.out.print('a');
                    System.out.print('l');
                } else {
                    System.out.print('f');
                    System.out.print('e');
                    System.out.print('w');
                }
            }
        }

        System.out.println();
        System.out.flush();
    }
}