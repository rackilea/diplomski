import java.util.*;

public class Lot {

public static void main(String[] args) {

        int n[] = {1,2,3,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};

        Random rd = new Random();

        for (int i = 0; i < 5; i++) {

            System.out.println(rd.nextInt(n[i]) + 1);
        }
    }

}