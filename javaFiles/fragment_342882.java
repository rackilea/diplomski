public class BottlesOfBeer
{
    int beerNum; // instance field

    // Constructor: accept number of beer bottles
    private BottlesOfBeer(int beerNum)
    {
        this.beerNum = beerNum; // Store in instance field
    }

    public static void main(String[] args)
    {
         // Assume first arg contains the number of bottles
         BottlesOfBeer beer = new BottlesOfBeer(Integer.parseInt(args[0]));
         beer.startDrinking();
    }

    public void startDrinking()
    {
        while (beerNum> 0)
        {
             System.out.println(beerNum + " bottles of beer on the wall " + beerNum + " bottles of beer. Take one down. Pass it around. " + (beerNum - 1) + " bottles of beer on the wall.");
             beerNum--;
        }
        System.out.println("No more bottles of beer on the wall");
    }
}