public class Roller {

    private Random random = new Random();

    public Dice roll()
    {
        return new Dice(random.nextInt(6) + 1);
    }
}