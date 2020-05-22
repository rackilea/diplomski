public static void main(String[] args) 
{
    Scanner reader = new Scanner (System.in);

    boolean finished = false;
    while(!finished)
    {
        try
        {
            System.out.print ("Type The x1 point please: ");
            int x1 = reader.nextInt();
            System.out.print ("Type The x2 point please: ");
            int x2 = reader.nextInt();
            System.out.print ("Type The y1 point please: ");
            int y1 = reader.nextInt();
            System.out.print ("Type the y2 point please: ");
            int y2 = reader.nextInt();
            double area = areaCircle(x1, x2, y1, y2);
            System.out.println ("The area of your circle is: " + area);
            double area = areaCircle(x1, x2, y1, y2);
            System.out.println ("The area of your circle is: " + area);
            finished = true;
        }
        catch(NumberFormatException e)
        {
            System.out.println("Please type in a number! Try again.");
        }
    } 
}