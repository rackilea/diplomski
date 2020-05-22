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