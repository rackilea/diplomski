public static void main(String args[]){
    //Get input
    int year = Integer.parseInt(JOptionPane.showInputDialog("Enter a year: "));
    int day = Integer.parseInt(JOptionPane.showInputDialog("Enter a day for Jan 1: 0-Sun, 1-Mon, 2-Tues, etc."));

    //Print year
    System.out.println("                                              " + year);

    //For each of the four rows
    for(int row=0; row<4; row++){
        //Display the Month headers
        for(int i=0; i<3; i++){
            displayHeader(3*row + i);
        }

        //Display the Week headers
        for(int i=0; i<3; i++){
            System.out.print("   Su  M   Tu  W  Th   F   S");
            System.out.print("   ");                
        }           
        System.out.println();

        //Display the rows of each month
        for(int week=0; week<5; week++){
            for(int month=0; month<3; month++){
                displayWeek(3*row + month, week, firstDayM(3*row + month, year, day), lastDayM(3*row + month, year));
                System.out.print("   ");
            }
            System.out.println();
        }
        System.out.println();                       
    }
}