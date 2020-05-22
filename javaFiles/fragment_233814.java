getIDs();
    pathCalc();
    System.out.println("Enter 0 to exit or any other number"+
                                            " to evaluate another path:");
    int choice = end.nextInt();
    while(choice != 0){
         //getIDs();
         pathCalc();
         System.out.println("Enter 0 to exit or any other number"+
                                            " to evaluate another path:");
         choice = end.nextInt();
    }