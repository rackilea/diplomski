package test.t100.t007;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

public class SystemIn {

    public static void main(String[] args) {
        String str = "blabla";
        ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
        System.setIn(bais);
        // We might use the ByteArrayInputStream here, but going with System.in..
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        System.out.println(input);
    }
}