while (true)
{
    Scanner input = new Scanner(System.in);
    System.out.println("Enter Positive Values");
    int num = input.nextInt();
    if (num < 0) break;

    if (num % 2 == 0)
        System.out.print("MultipleOfTwo");
    else if (num % 3 == 0 && num % 5 == 0)
        System.out.print("MultipleOfThreeAndFive");
    else if (num % 7 == 0 && num % 9 == 0)
        System.out.print("MultipleOfSevenOrNine");
    else
        System.out.print("Invalid");
}