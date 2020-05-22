public static void main (String[] args)
{
    Scanner input = new Scanner(System.in);
    String[] strings = new String[3];

    for (int i = 0; i < strings .length; i++)
    {
        System.out.println("Please enter name");
        strings [i] = input.next();
    }
}

Arrays.sort(strings);