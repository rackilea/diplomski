public VGenerator
{
    private final RandomNumberGenerator rng; 

    // constructor
    public VGenerator(RandomNumberGenerator rng)
    {
       this.rng = rng;
    }

    public long generateID(length)
    {
       double randomNumber = this.rng.getRandomNumber();
       // ... use random number in calculation somehow ...
       return id;
    }
}