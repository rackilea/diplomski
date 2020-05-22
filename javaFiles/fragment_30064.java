public static void main(String[] args)
{
    StackReversal s = new StackReversal();
    Scanner input = new Scanner(System.in);
    System.out.print("Enter strings:");
    String in = "";
    while (!in.equals("end"))
    {
        in = input.nextLine();
        if (in.equals("end"))
            break;
        else
            s.push(in);
    }
    System.out.println("Strings:" + s);
}