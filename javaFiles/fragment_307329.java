import javax.swing.JOptionPane;

public class Assignment4{   
public static int lastDayM(int month, int year){
    //calculate last day for every month
    //status: working 
    if (month == 3 || month == 5 || month == 8 || month == 10)
        return 30;
    if(month == 1){
        if (year % 4 == 0){
            return 29;
        }
        return 28;
    }
    return 31;
}

public static int firstDayM(int month, int year, int janOneDay){
    int firstDayM = janOneDay;

    for(int i=0; i<month; i++){
        firstDayM += lastDayM(i, year);
    }

    return firstDayM % 7;
}

public static void displayHeader(int month){
    //display the month headers in a 3x4 format
    //status:working
    switch (month) {
        case 0: 
            System.out.print("            January"); break;
        case 1:
            System.out.print("                         February"); break;
        case 2: 
            System.out.println("                       March"); break;
        case 3: 
            System.out.print("             April"); break;
        case 4: 
            System.out.print("                           May"); break;
        case 5: 
            System.out.println("                            June"); break;
        case 6: 
            System.out.print("             July"); break;
        case 7: 
            System.out.print("                           August"); break;
        case 8: 
            System.out.println("                        September"); break;
        case 9: 
            System.out.print("           October"); break;
        case 10: 
            System.out.print("                          November"); break;
        case 11: 
            System.out.println("                      December"); break;
    }
}

public static void displayWeek(int month, int week, int firstDay, int lastDay){
    //status: almost working for every case. Only issue is the last week
    //display the months one week at a time
    switch (week){
        case 0:
            for (int b=0; b<firstDay; b++) {
                System.out.print("    ");
            }
            for (int d=1; d<8-firstDay; d++){
                System.out.print((d<10 ? "   " : "  ")  + d);
            }
            break;
        case 1:
            for (int d=8-firstDay; d<15-firstDay; d++){
                System.out.print((d<10 ? "   " : "  ")  + d);
            }
            break;
        case 2:
            for (int d=15-firstDay; d<22-firstDay; d++){
                System.out.print((d<10 ? "   " : "  ")  + d);
            }
            break;
        case 3:
            for (int d=22-firstDay; d<29-firstDay; d++){
                System.out.print((d<10 ? "   " : "  ")  + d);
            }
            break;
        case 4:
            if(lastDay == 28 && firstDay==0){
                System.out.print("                        ");
                break;
            }
            for (int d=29-firstDay; d<36-firstDay; d++){
                if(d<lastDay+1){
                    System.out.print((d<10 ? "   " : "  ")  + d);
                }else{
                    System.out.print("    ");
                }
            }
            break;
    }
}

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
}