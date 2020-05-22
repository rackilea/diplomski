// A is our base class
class A{
    public int currentState = 0;
    public def listeners = [];
    public void setCurrentState( int i ) 
    { 
        // call each of our listeners with the current state
        this.currentState = i;
        listeners.each { it( i ); }
    }

    public A()
    {
        this.addListener( this.&_onStateChanged );
    }

    public void addListener( def callback )
    {
        this.listeners.add( 0, callback );
    }

    protected void _onStateChanged( int state )
    {
        println "The state in A is $state";

        // depending on the state launch some events.
        // these can changed the current state of
        // B
        if( state == 0 || state == 1 )
        {
            def event = new MyEvent( this );
            event.execute();
        }
    }
}

// B is a more specific version of A
class B extends A
{
    public B()
    {
        super();
        this.addListener( this.&_onBStateChanged );
    }

    protected void _onBStateChanged( int state )
    {
        println "The state in B is $state";

        // launch specific events based on the current state
        if( state == 0 )
            println "Launch a specific event!";
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
b.currentState = 0;