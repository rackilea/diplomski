public static void forloop(String[][] animals) // here the array has been passed as an argument
{                 

     int endangered = 20;
     String answer = "";
     Scanner scanner = new Scanner(System.in); // allows the user to input

    for(int i = 0;i<5; i++) //for loop to print the below 
    //print 5 times using the different animal names.
    {
        System.out.println(animals[i][0] + ":");
        System.out.println("How many are left in the wild?"); // prints the question
        answer = scanner.nextLine();
        int count = Integer.parseInt(answer);
        animals[i][1] = String.valueOf(count);
        if(count<=endangered) // if statement used to print out the smallest number types by the user
        {

            System.out.println("The most endangered animal is the " + animals[i][0] + "."); // prints out the most endangered animal
            System.out.println("There are only " + answer + " left in the wild.");
        }

    }
    //close the scanner
    scanner.close();

    print(animals);

}