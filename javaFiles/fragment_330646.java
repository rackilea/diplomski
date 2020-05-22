class BetterValueHolder extends ValueHolder
{
    private int betterValue;

    BetterValueHolder(final int betterValue)
    {
        // not actually required, it's added implicitly anyway.
        // just to demonstrate where your constructor is called from
        super();

        try
        {
            Thread.sleep(1000); // just to demonstrate the race condition more clearly
        }
        catch (InterruptedException e) {}

        this.betterValue = betterValue;
    }

    @Override
    public int getValue()
    {
        return betterValue;
    }
}