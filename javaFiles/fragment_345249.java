public class Generator implements Runnable 
{
    ...
    private boolean genComplete = false;

    public synchronized void setComplete() {
        getComplete = true;
    }

    public synchronized isComplete() {
        return genComplete;
    }
    ...
    /**
     * Begins world generator thread.
    */
    @Override
    public void run()
    {
        world.initializeWorldTileData();
        generateWholeWorld();
        System.out.println("Completed");
        setComplete();
    }
    ...
}