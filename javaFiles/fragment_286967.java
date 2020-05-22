private expensiveOperation()
{
    try {
        for(SomeObject among : millionsOfItems) {
            // Do stuff
            if(Thread.currentThread().interrupted()) {
                // Possibly log the interruption as you would for the exception
                break;
            }
        }
    } catch(InterruptedException ie) {
        // Probably just ignore or log it somehow since this is really a normal condition
    } finally {
        // If your thread needs special cleanup, this is the place to put it
        // This block will be triggered by exceptions as well as breaks
    }
}