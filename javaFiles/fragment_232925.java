public void initialise() throws InitialisationException
    {
         for (MessageProcessor processor : processors)
       {
         // MULE-5002 TODO review MP Lifecycle
            if (processor instanceof Initialisable /* && !(processor instanceof Transformer) */)
           {
                ((Initialisable) processor).initialise();
            }
        }
    }