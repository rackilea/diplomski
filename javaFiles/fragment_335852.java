Scanner Red = new Scanner(System.in);
    TicketHandler objectOne = new TicketHandler(); //HERE I CREATED AN OBJECT
    System.out.println();
    int moneyin = 200;
    while (moneyin <= 200)
    {
        System.out.println("Insert £" + moneyin);
        int KeyIn = Red.nextInt();
        moneyin = moneyin - KeyIn;

        if (moneyin == 0){
            System.out.println("Enjoy");

            objectOne.AmountOfTickets = objectOne.getAmountOfTickets() - 1; //HERE I USED IT

            break;
    }