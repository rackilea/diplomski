public class Pro8Point3
{
    public static void main(String[] args) {
        int space=29;
        char ch;

        for (int i = 1; i <= 5; i++) {
            ch = 'A';  

            //Print spaces in decreasing order. A is at 29th position.
            for (int j = 1; j <= space; j++) {
                System.out.print(" ");
            }

            //Print Triangle.
            for (int k = 1; k <= i; k++) {
                System.out.print(ch + " ");
                ch+=1;
            }

            space--;

            System.out.println();
        }
    }
}