// method does not need to be synchronized - no thread besides this one is
// accessing it. Other threads have their "own" method. Would make a difference
// if this method was static, i.e. shared between threads.
private boolean removeListElementIfPossible()
{
    synchronized(sharedList)
    {
        // within synchronized so we can be sure that checking emptyness + removal happens atomic
        if (!sharedList.isEmpty())
        {
            int removedItem = (Integer) (sharedList.element());
            sharedList.remove();
            System.out.println("Thread " + this.name + ": " + removedItem + " removed");
        } else {
            // unable to remove an element because list was empty
            return false;
        }
    }
    try {
        sleep(1000);
    } catch (InterruptedException e) {
        this.interrupt();
    }
    // an element was removed
    return true;
}