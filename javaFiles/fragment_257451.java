package javaapplication19;

import java.util.Scanner;

public class Train {

    static char[] seat1 = new char[9];

    public static void book() {

        int dest, sno;

        Integer Tid = 1;

        Scanner sc = new Scanner(System.in);
        Scanner sc2 = new Scanner(System.in);

        System.out.println("Where do you want to go?");
        System.out.println("1. Main Entrerance to Night Safari");
        System.out.println("2. Main Enterance to River Safari");
        System.out.println("3. River Safari to Main Enterance");
        dest = sc.nextInt();
        if (dest == 1 && Tid != null) {
            System.out.println("_1" + seat1[0] + "_|_2" + seat1[1] + "_|_3" + seat1[2] + "_");
            System.out.println("_4" + seat1[3] + "_|_5" + seat1[4] + "_|_6" + seat1[5] + "_");
            System.out.println("_7" + seat1[6] + "_|_8" + seat1[7] + "_|_9" + seat1[8] + "_");
            System.out.println("Enter seat number to select seat:");
            sno = sc.nextInt();

            if (sno >= 1 && sno <= 9) {
                if (seat1[sno - 1] != 'B') {

                    seat1[sno - 1] = 'B';

                    book();//here is working, it will go back again but when I re enter book(); and select dest1 agn it doesn't changed selected sno to B
                } else {
                    System.out.println("Seat Already Booked, Choose Another ");

                    book();
                }

            }
        } else {
            System.out.println("Invalid Seat Number, Select Again ");

            book();
        }
    }

    public static void init() {
        for (int i = 0; i < 9; i++) {
            seat1[i] = 'A';
        }
    }
}