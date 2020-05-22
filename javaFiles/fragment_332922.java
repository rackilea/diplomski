public static int move()
{
    System.out.println("What do you want to do?");
    Scanner scan = new Scanner(System.in);
    int userMove = scan.nextInt();
    return userMove;
}

public static void usersMove(String playerName, int gesture)
{
    int userMove = move(); //Now error will go.

    if (userMove == -1)
    {
        break;
    }