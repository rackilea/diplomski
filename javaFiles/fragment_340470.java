import java.util.*;

public class ProblemSolved {

    java.util.Scanner scan = new java.util.Scanner(System.in);
    boolean seating[] = new boolean[24];
    String seatings[] = new String[24];

    boolean runAgain = true;
    int input;


    //runs the program with four options
    public void runProgram()
    {
        do{
            System.out.println("");
            System.out.println("Press 1 to change a seat, 2 to print the seating chart,"
                    + " 3 to clear all the seats or 4 to exit the program");
            input = scan.nextInt();
            scan.nextLine();
            switch(input)
            {
            case 1:
                emptySeat();
                break;
            case 2:
                seatingChart(seatings);
                break;
            case 3:
                clearSeats(seatings);
                break;
            case 4:
                runAgain = false;
                break;
            default:
                System.out.println("That is not an option, please try again!");
            }
        }while(runAgain);
    }

    //changes an empty seat to a student's name at any location
    public void emptySeat()
    {
        System.out.println("Who will be taking this seat?");

        String name = scan.nextLine();
        System.out.print("Which seat would you like (1-24)\n");
        int seat = scan.nextInt();
        if (seat > 0 && seat <= 24) {
            if (seatings[seat-1] != null) {
                System.out.print("That seat is taken.\n");
            } else {
                seatings[seat - 1] = name;
                System.out.print("Seat number " + seat + " was assigned.\n");
            }
        }

    }

    //replace an empty seat with a person in the seating chart
    public static void seatingChart(String seat[]) {
        for(int i = 0; i < seat.length; i++) {  
            if(seat[i]!=null) {
                System.out.print(seat[i] + " ");
            } else {
                System.out.print("o ");
            }    

            if((i+1) % 8 == 0) {
                System.out.println();
            }
        }
    }

    //clears all the seats
    public void clearSeats(String seat[])
    {
            for(int i = 0; i < seat.length; i++) {  
                if(seat[i] == null) {
                    System.out.print("empty seat  ");
                } else {
                    System.out.print("not empty seat  ");
                }    

                if((i+1) % 8 == 0) {
                    System.out.println();
                }
            }
    }

    public static void main(String[] args) 
    {
        ProblemSolved prog = new ProblemSolved();
        prog.runProgram();
    }

}