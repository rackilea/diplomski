public static String askFileName() 
{
    Scanner scanner = new Scanner(System.in);
    String temp = null;

    boolean flag = true;
    while (flag)
    {
        System.out.print("Type a file name: ");
        String name = scanner.nextLine();
        File file = new File(name);
        try 
        {
            Scanner scanner1 = new Scanner(file);
            temp = name;
            flag = false;
        }
        catch (FileNotFoundException e)
        {
            flag = true;
            temp = null;
        }
    } 
     return temp; //return value here
}