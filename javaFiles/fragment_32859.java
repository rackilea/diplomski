while(loop)
{
    // validate int using while loop
    while(!kb.hasNextInt())                             
    {
        System.out.println("you must enter a number! ");
        kb.next();
    }

    choice = kb.nextInt();

    switch(choice)
    {
    case 1 :
            language = "FRENCH";
            loop = false;
            break;
    case 2 : 
            language = "GERMAN";
            loop = false;
            break;
    case 3 :
            language = "SPANISH";
            loop = false;
            break;
    }
}   

System.out.println("Thank You " + studentID + " you have been registered for " + language);