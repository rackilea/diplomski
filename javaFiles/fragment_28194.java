while(sym != '#')
    {

    if (sym >= 'a' && sym <= 'z')
        {
        low++;
        }

    System.out.print("Enter a character # to quit: ");
    sym = input.next().charAt(0);

    }