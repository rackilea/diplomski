public class print1 extends PrintStar implements PrintBehavious{

    @Override
    public void printStarline(int num, int input) {

        int blank = (input - num) / 2;
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }

        // except the top and bottom there should be two *
        System.out.print("*");
        if (num > 1) {
            for (int i = 1; i <= num - 2; i++) {
                System.out.print(" ");
            }
            System.out.print("*");
        }

        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("");

    }


    }
--> print2 : 
public class print2  extends  PrintStar implements PrintBehavious{
    @Override
    public void printStarline(int num, int input) {

        int blank = (input - num) / 2;
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        for (int i = 1; i <= num; i++) {
            System.out.print("*");
        }
        for (int i = 1; i <= blank; i++) {
            System.out.print(" ");
        }
        System.out.println("");
    }




}