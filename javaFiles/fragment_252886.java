import java.util.Scanner;

class RLE {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String input = sc.next();
    int count = 0;

    String output = "";
    if (!input.isEmpty()) {
        char actual = input.charAt(0);
        for (char c : input.toCharArray()) {
            if (actual == c) {
                count++;
            } else {
                output += actual + Integer.toString(count);
                actual = c;
                count = 1;
            }
        }
        if (count > 0) {
            output += actual + Integer.toString(count);
        }
    }
    System.out.println(output);

}
}