class IsolatedThreadGroup extends ThreadGroup {
     private Throwable uncaughtException; // synchronize access to this

     public IsolatedThreadGroup( String name ){
        super( name );
     }

    public void uncaughtException( Thread thread, Throwable throwable ) {
        if ( throwable instanceof ThreadDeath ) {
           return; // harmless
        }
        synchronized ( this ) {
            if ( uncaughtException == null ) {
                uncaughtException = throwable; // will be reported eventually
           }
        }
        getLog().warn( throwable );
    }
 }