public static void main(String[] args) {
    int year;
    System.out.println("Enter a year in numbers:");
    Scanner input = new Scanner(System.in);

    while (!input.hasNextInt()) {
        System.out.println("Enter a year in numbers:");
        input.next();
    }

    year = input.nextInt();
    //System.out.println("Enter a year:");

    input.close();


    boolean is_leap = false;

    if (year % 4 == 0)
    {
        if (year % 100 == 0)
        {
            if (year % 400 == 0)
                is_leap = true;
            else
                is_leap = false;
        }
        else
            is_leap = true;
    }
    else
        is_leap = false;

    if(is_leap)
        System.out.println(year + " is a leap year!");
    else
        System.out.println(year + " is not leap year!");

}