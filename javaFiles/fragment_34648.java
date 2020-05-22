Scanner sc = new Scanner(System.in);
while(whatever)
{
     String s = getInput(sc);
     ....

}
sc.close();

public static String getInput(Scanner in) 
{
    System.out.print("> ");
    String input = in.nextLine();
    input.toLowerCase();
    return input;
}