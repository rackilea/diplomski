import java.util.Scanner;
public class Read {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isCheck = true;
        while (isCheck) {
            String str = sc.next();
            switch (str) {
                case "A":
                    System.out.println("A");
                    isCheck = false;
                    break;
                case "M":
                    System.out.println("M");
                    isCheck = false;
                    break;
                case "S":
                    System.out.println("S");
                    isCheck = false;
                    break;
                default:
                    System.out.println("Not Valid : Enter next");
                    isCheck = true;

            }
        }

    }

}