public abstract class Example {
    protected Foo callbackHandler;

    public void setCallbackHandler( Foo handler ) {
        this.callbackHandler = handler;
    }

    protected void doCallback( SomeType event ) {
        if ( this.callbackHandler != null ) {
            this.callbackHandler.doYourThing( event );
        }
    }
}