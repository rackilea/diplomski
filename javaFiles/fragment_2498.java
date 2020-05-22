import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter number");
        int num = in.nextInt();

        List<Integer> lst = new ArrayList<>();

        for (int p = 9; p >= 2; p--) {
            while (num % p == 0) {
                num /= p;
                lst.add(p);
            }
        }

        String smallestNumber = "";
        for (int i = lst.size() - 1; i >= 0; i--) {
            smallestNumber = smallestNumber + lst.get(i);
        }
        System.out.println("Smallest number : " + smallestNumber);
    }
}