import java.util.Scanner;

public class HotelBooking {

    Scanner in;
    String userInput;
    String userName;

    String[] hotelList;
    int i, progressiveNumber, repeat;

    HotelBooking() {

        progressiveNumber = 0; // fills the array or removes from it
        repeat = 0; // repeats this loop to check if it works
        hotelList = new String[10]; // creates a 10 nr spaced  array

        while (repeat < 5) {  // repeats 5 times to check if it is working
            in = new Scanner(System.in);

            System.out.print("Enter choice (in this case a to add or b to remove): ");
            userInput = in.next();

            addToArray(); // add names to array. It does not handle if user from begining choses b. it is just a demo afterall
            removeFromArray(); // removes from array

        }

    }

    private void addToArray() {
        // METHOD TO ADD STRING TO ARRAY
        if (userInput.equals("a")) {// handles only a. You could add "A" or whatever
            System.out.print("Enter name to insert: ");
            userName = in.next();

            for (i = 0; i < hotelList.length; i++) {
                hotelList[progressiveNumber] = userName;
            }
            progressiveNumber++;

            System.out.print("Printing the hotel list: ");
            for (String scan : hotelList) {
                System.out.print(scan + " ");
            }
            System.out.println();
            repeat++;
        }
    }

    private void removeFromArray() {
        // METHOD TO REMOVE STRING FROM ARRAY
        if (userInput.equals("b")) { // handles only b. You could add "B" or whatever
            System.out.print("Enter name to remove: ");
            userName = "";
            progressiveNumber--;

            for (i = 0; i < hotelList.length; i++) {
                hotelList[progressiveNumber] = userName;
            }

            System.out.print("Printing the hotel list: ");
            for (String scan : hotelList) {
                System.out.print(scan + " ");
            }
            System.out.println();
            repeat++;
        }
    }

    public static void main(String[] args) {

        new HotelBooking();

    }

}