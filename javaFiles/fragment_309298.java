public static Scanner keyBoardRead = new Scanner(System.in);

public static int intEntry()
{
    int entry;
    if (keyBoardRead.hasNextInt())
    {
        entry = keyBoardRead.nextInt();
        System.out.println("entry variable = "+entry);
        // Here the correct entry prints but doesn't seem to return
        return entry;
    }
    keyBoardRead.next();
    System.out.println("Invalid entry.\n");
    return intEntry();
}