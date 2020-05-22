private Runnable runnable = new Runnable()
{
    @Override
    public void run()
    {
        Thread.sleep(6000);
        biomass = biomass +1;
    }
};