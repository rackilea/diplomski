private final Runnable going = new Runnable() {
    @Override
    public void run() {
        robot.go(false);
    }
});

private final Runnable spinning = new Runnable {
    @Override
    public void run() {
        robot.spin(false);
    }
});

// other commands 


private boolean isFoundAfter(Runnable command)
{
    command.run();
    while (robot.isMoving())
    {
        if (thingFound())
        {
            robot.stop()
            return true;
        }
        Thread.yield();
    }
    return false;
}

public boolean search()
{
    if (isFoundAfter(going)) return true;

    if (isFoundAfter(spinning)) return true;   

    //etc - around 8 more similar commands
    return false; //didn't find what it was looking for
}