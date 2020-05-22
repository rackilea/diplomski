while (true){     
    if (drink.equals ("pepsi"))
    {
        System.out.println ("That will be 4 dollars");
        System.out.println ("Enter 4 dollars");
        money = kbd.nextInt();
        if ( money == 4 )
        {
            System.out.println ("Thanks.");
            break;
        }
        else
        {
            System.out.println ("You idiot it's four dollars");
        }
    }
    else if (drink.equals ("coke"))
    {
        System.out.println ("That will be 6 dollars");
        System.out.println ("Enter 6 dollars");
        money = kbd.nextInt();
        if ( money == 6 )
        {
            System.out.println ("Thanks.");
            break;
        }
        else
        {
            System.out.println ("You idiot it's four dollars");
        }

    }
    else {
        System.out.println("You didn't make a valid choice, please choose coke or pepsi");
    }

    // Get another input to continue program, here.
}