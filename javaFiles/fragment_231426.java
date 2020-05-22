for (person = 1; person <= 5; person ++)
{
    System.out.println ("How do you sweeten your coffee");
    System.out.println ("1. I Don't");
    System.out.println ("2. With Sweetner");
    System.out.println ("3. With Sugar");

    preference = input.nextInt();

    while(preference != 1 && preference != 2 && preference != 3) {
        System.out.println ("Sorry that is not a valid option");
        System.out.println ("How do you sweeten your coffee");
        System.out.println ("1. I Don't");
        System.out.println ("2. With Sweetner");
        System.out.println ("3. With Sugar");
        preference = input.nextInt();
    }

    if(preference == 1) {
        nothing ++;
    } else if(preference == 2) {
        sweetner ++;
    } else if(preference == 3) {
        sugar ++;
    }
}