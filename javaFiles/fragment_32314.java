Scanner sc = new Scanner(System.in);
sc.useDelimiter("\n");
String n;

while(!sc.hasNext("[a-zA-Z ]+"))
{
    System.out.println("That's not a name!");
    sc.nextLine();
}
n = sc.next();