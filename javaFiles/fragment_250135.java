package person;

import java.util.Random;
import java.util.Scanner;

public class Cat {

    public static void main(String[] args) {

        int max = 100;
        int min = 0;
        int diff = max-min;
        Random rn = new Random();
        int i = rn.nextInt(diff+1);
        i+=min;
        int k;
        for (k=0; k<15; k++) {
            Scanner sb = new Scanner(System.in);
            System.out.println("Enter your number");
            int x = sb.nextInt();
            if(x>i) {
                System.out.println(x+"is bigger than i");
            } else if(x<i) {
                System.out.println(x+"is smaller than i");
            } else if (x==i) {
                System.out.println(x+"is equals to i "+" "+" no. of try"+k+1);
                break;    
            }
        }
        if(sb !=null) {
            sb.close();
        }
    }
}