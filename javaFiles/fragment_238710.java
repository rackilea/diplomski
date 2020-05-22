public class V0206 {

    public static void main(String[] args) {

        java.util.Scanner sc = new java.util.Scanner(System.in);

        int x = sc.nextInt();
        int y = 400;
        int z = 100;
        int q = 4;
        int rest = (int) (x % y);
        int rest2 = (int) (x % z);
        int rest3 = (int) (x % q);

        String result = (rest3 == 0 && rest2 != 0 || rest == 0 && rest2 == 0) ? "Leap year" : "Not leap year";

        // This if statement can be replaced by System.out.println(result);
        if (result.equals("Leap year")) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not leap year");
        }

    }
}