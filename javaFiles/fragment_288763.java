public static int move()
{
    System.out.println("What do you want to do?");
    Scanner scan = new Scanner(System.in);
    int userMove = scan.nextInt();
    return userMove;
}