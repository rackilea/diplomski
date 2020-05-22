import java.util.Scanner;

public class Testing {
    //Adding global variables to be used by various methods
    static Scanner input = new Scanner(System.in);
    static String menuChoice;
    static double childTicket = 1.20;
    static double adultTicket = 2.50;
    static double adultFlexi = 12.00;
    static double childFlexi = 8.00;
    static String ticketType;
    static String ticketChoice;
    static int adultTicketQty;
    static int childTicketQty = 0;
    static String destinationZone;
    static double adultFinalPrice;
    static double childFinalPrice;
    static boolean shouldBeRunningAgain = true;


    public static void main(String[] args) {
        menu(); //calling the menu method within the main method to start the process
    }
    public static void menu() {
        do {
            System.out.println("Press 1 for information");
            System.out.println("Press 2 to purchase Standard Tickets");
            System.out.println("Press 3 to purchase Flexi tickets");
            menuChoice = input.next(); //allowing user to choose what tickets to buy or just to see information of services

            switch (menuChoice) { //switch statement to record and output information based on users input
                case "1": { //prints information regarding pricing, ticket age restrictions and support
                    System.out.println("The standard ticket may be a single or return ticket for an adult (16+) or a child");
                    System.out.println("The flexi ticket covers all journeys for one 24 hour period for either a child or an adult");
                    System.out.println("A single ticket's price depends on the journey length, single or return and if it is for an adult or a child");
                    System.out.println("a Flexi ticket for a child costs €8.00 and a Flexi ticket for an adult costs €12.00");
                    System.out.println("Our Customer Care telephone number for this terminal is 0830462920, please call if further support is required");
                    break;
                }
                case "2": {
                    ticketChoice = "standard"; //records the value of standard within the ticketChoice global variable
                    chooseTickets(); //initiates the choose tickets method
                    break;
                }
                case "3": {
                    ticketChoice = "flexi"; //record the value of flexi within the ticketChoice global variable
                    chooseTickets();
                    break;
                }
                case "a": { //allows user to enter the admin interface
                    admin();
                    break;
                }
                default: { //allows for user to input a value outside of the options and notify's them to try again
                    System.out.println("Invalid choice, please choose from 1 to 3");
                    break;
                }
            }
        }while (shouldBeRunningAgain);
    }
    public static void chooseTickets() { //payment method for choosing adult or child and quantity, and purchasing.
        System.out.println("You have chosen to purchase " + ticketChoice + " ticket(s)");
        System.out.print("Enter 1 for an adult ticket, Enter 2 for a child ticket: ");
        String ticketAgeGroup = input.next(); //assigns users choice to string variable
        switch(ticketAgeGroup) { //allows user to choose quantity and destination based on choice of adult or child
            case "1":{//case for adult tickets
                System.out.println("you have chosen adults ticket");
                ticketType = "adult";
                System.out.print("Please enter the quantity of tickets: ");
                adultTicketQty = input.nextInt();
                System.out.print("please enter your destination zone (1, 2, 3, 4): ");
                destinationZone = input.next();
                if(ticketChoice.equals("flexi")) { //if statement to calculate the finalPrice variable value if the ticketChoice is Flexi
                    adultFinalPrice = (adultFlexi*adultTicketQty);
                }
                else {
                    adultFinalPrice = (adultTicket*adultTicketQty); //else calculates the finalPrice variable value if the ticketChoice is standard
                }
                switch(destinationZone){ // switch statement to calculate the final price depending on the destination's zone and their extra amount.
                    case "1":{
                        adultFinalPrice = adultFinalPrice + (0);
                        break;
                    }
                    case "2":{
                        adultFinalPrice = adultFinalPrice + (adultTicketQty*.50); //calculation to add the extra amount for the destination
                        break;
                    }
                    case "3":{
                        adultFinalPrice = adultFinalPrice + (adultTicketQty*1.0);
                        break;
                    }
                    case "4":{
                        adultFinalPrice = adultFinalPrice + (adultTicketQty*1.50);
                        break;
                    }
                    default:{
                        System.out.println("you have entered an invalid choice please choose from 1 to 4");
                        //recursion if the user enters an invalid choice
                        break;
                    }
                } //end of the switch statement
                System.out.println("The total price for your purchase is €" + adultFinalPrice );

                System.out.print("Would you like to purchase more tickets? enter 1 if so, 2 if not: "); //allows user to purchase other tickets
                String moreTicketChoice = input.next();
                if(moreTicketChoice.equals("1")) {
                    chooseTickets();
                }
                else {
                    System.out.println("you have chosen against purchasing more tickets");
                }
                payment(); //initiates the payment method after user has chosen quantity and ticket type etc
            }

            case "2":{ //case for children's tickets
                System.out.println("you have chosen children's ticket");
                ticketType = "child";
                System.out.println("Please enter the quantity of tickets: ");
                childTicketQty = input.nextInt();
                System.out.print("please enter your destination zone (1, 2, 3, 4): ");
                destinationZone = input.next();
                if(ticketChoice.equals("flexi")) { //adjusts the price if user chooses the flexi option
                    childFinalPrice = (childFlexi*childTicketQty);
                }
                else {
                    childFinalPrice = (childTicket*childTicketQty);
                }
                switch(destinationZone){ //adjusts price to account for the destination's zone chosen by user
                    case "1":{
                        childFinalPrice = childFinalPrice + (0);
                        break;
                    }
                    case "2":{
                        childFinalPrice = childFinalPrice + (childTicketQty*.50);
                        break;
                    }
                    case "3":{
                        childFinalPrice = childFinalPrice + (childTicketQty*1.0);
                        break;
                    }
                    case "4":{
                        childFinalPrice = childFinalPrice + (childTicketQty*1.50);

                        break;
                    }
                    default:{
                        System.out.println("you have entered an invalid choice please choose from 1 to 4");
                        chooseTickets();
                        break;
                    }
                }
                System.out.println("The total price for your purchase is €" + childFinalPrice );
                System.out.print("would you like to purchase more tickets? enter 1 if so, 2 if not: "); //allows user to purchase other tickets
                String moreTicketChoice2 = input.next();
                if(moreTicketChoice2.equals("1")) {
                    chooseTickets();
                }
                else if(moreTicketChoice2.equals("2")){
                    System.out.println("you have chosen against purchasing more tickets");
                }
                payment();
                break;
            }
            default:{
                System.out.println("you have entered an invalid choice please enter 1 or 2");
                chooseTickets();
                break;
            }

        }

    }
    public static void payment() { //method to complete the payment process for the purchase
        System.out.println("test");
        shouldBeRunningAgain = false;

    }
    public static void printTickets() { //method to notify the customer that their tickets are printing 

    }
    public static void admin() { //method to control the admin's interface

    }
}