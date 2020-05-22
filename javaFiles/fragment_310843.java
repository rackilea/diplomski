System.out.println("Please enter the number of judges.");  
do
{
    System.out.println("Please ensure the number you entered is between 3 and 6");
    while(!scan.hasNextInt())
    {
        scan.nextLine();
        System.out.println("Please ensure the number you entered is a number");
    }
    numJudges = scan.nextInt();

} while (!(numJudges >=3 && numJudges<=6));