Listener listener = new Listener()
{
    private boolean ignore = false;

    @Override
    public void handleEvent(Event e)
    {
        if(ignore)
            return;

        ignore = true;
        doPotentiallyCyclicStuff();
        ignore = false;
    }
};