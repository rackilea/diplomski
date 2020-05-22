Scanner input = new Scanner(System.in);
System.out.print("Enter first, last name: ");
name = input.nextLine();
if(!name.equals("END"))
{
    while(score != -1)
    {
        System.out.print("Enter a score: ");
        score = input.nextInt();
        totalS = (totalS+score);
    }
}