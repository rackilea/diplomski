import java.util.Scanner;

public class StackOverflow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int range=scanner.nextInt();
        scanner.next();

        for(int i=1;i<=range;i++){
            String stringInput =scanner.nextLine();
            String[] total =stringInput.split("\\s");
            int length=total.length;
            System.out.println(length);
        }

        scanner.close();
    }
}