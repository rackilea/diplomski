public static void main(String[] args)
{
    Scanner keyboard = new Scanner(System.in);
    int choice = aMenu(keyboard);
    System.out.println("You typed: "+choice);
    choice = aMenu(keyboard);
    System.out.println("You typed: "+choice);
}

public static int aMenu(Scanner keyboard)
{
    int result = 0;
    System.out.println("In aMenu... enter an int: ");
    result = keyboard.nextInt();
    return result;
}