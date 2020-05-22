public static void main (String [] args) 
{
    int count = 0;
    int die1, die2;
    do 
    {
        // New roll each time
        die1 = (int)(Math.random()*6)+1;
        die2 = (int)(Math.random()*6)+1;

        count = count + 1;
        System.out.println ("You rolled a:" + die1);
        System.out.println ("You rolled a:" + die2);
        System.out.println ("This is roll number:" + count);
    } while (die1 + die2 > 2);

    System.out.println ("Congratulations...Snake Eyes");
}