int last_input = 0;
    int input = 0;
    int total = 0;
    int update = 0;

    Scanner inputDevice = new Scanner(System.in);

    do
    {   
        System.out.println("Enter any number");
        input = inputDevice.nextInt();

        total = total + input;

        if(last_input == input)
            break;

        last_input = input;

    }while(input != 0); // Or How would i insert a second parameter that stops the loop when a number is entered twice in a row?

    System.out.println("The sum of the numbers is " + total);