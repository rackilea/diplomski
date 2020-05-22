// A is our base class
class A{
    public int currentState = 0;
    public int nextState = 0;
    public boolean canChange = true;
    public void setCurrentState( int i ) 
    { 
        if( this.canChange )
        {
            this.currentState = i;
            this._onStateChanged();
        }
        else
            this.nextState = i;
    }

    protected void _onStateChanged()
    {
        println "The state in A is $currentState";

        // depending on the state launch some events.
        // these can changed the current state of
        // B
        if( this.currentState == 0 )
        {
            def event = new MyEvent( this );
            event.execute();
        }
    }
}

// B is a more specific version of A
class B extends A
{
    protected void _onStateChanged()
    {
        this.canChange = false;
        println "The state in B is $currentState";
        super._onStateChanged();
        println "The state in B afterwards is $currentState";

        // launch specific events based on the current state
        if( this.currentState == 0 )
           println "Launch a specific event!";

        this.canChange = true;
        if( this.nextState != 0 )
        {
            int state = this.nextState;
            this.nextState = 0;
            this.currentState = state;
        }
    }
}

// simple event class that can change the status of B
class MyEvent
{
    private B b = null;
    public MyEvent( B b )
    {
        this.b = b;
    }
    public void execute()
    {
        // do some stuff
        b.currentState++;
    }
}

// program start
def b = new B();
b.currentState = 0;​