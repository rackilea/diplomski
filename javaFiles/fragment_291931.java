Scanner scan = new Scanner(System.in);
System.out.print("\nEnter a sentence:");
String s1 = scan.nextLine();

do
{
    System.out.println("\nEntered String: " + s1 + "\n");

    Scanner input = new Scanner(s1);
    int word = 0;
    while (input.hasNext())
    {
        word++;
        System.out.println("Word #" + word + ": \t" + input.next());
    }

    System.out.print("\nEnter 'q' to quit, enter string to continue:  \t");
    s1 = scan.nextLine();

} while(!s1.equals("q"));

scan.close();