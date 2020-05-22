public static void main(String args[])
{
    Drunk drunk = new Drunk();
    while (true) 
     { 
         DrunkResult result = drunk.drunkWalkToJail();
         System.out.println("Walked " + result.getSteps() + " blocks, and Landed at " + (result.isInJail() ? "Jail":"Home"));
     } 
}
public DrunkResult drunkWalkToJail()
{
    int street;
    int stepCount = 0;

    do
    {
        street = 6;
        double move = Math.random();
        stepCount++;
        if (move > 0.5)
        {
            street++;
        }
        else
        {
            street--;
        }
    }
    while (street != 1 && street != 11);

    return new DrunkResult(street == 11, stepCount);
}