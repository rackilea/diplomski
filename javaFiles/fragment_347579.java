import java.util.*;

public class AdderApp {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.println("Enter A array");
        char[] aIn = input.nextLine().replace(" ", "").toCharArray();
        System.out.println("Enter B array");
        char[] bIn = input.nextLine().replace(" ", "").toCharArray();

        StringBuilder result = new StringBuilder();        
        Adder bit = new Adder(false, false, false);

        for (int i = aIn.length - 1; i >= 0; --i) {
            bit = new Adder((aIn[i] == '1'), (bIn[i] == '1'), bit.getCout());
            result.append(bit + " ");
        }
        System.out.println(bit.getCout() ? "overflow!" : result.reverse());
    }
}