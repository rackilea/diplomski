class TestChild extends TestParent{

    private int i = 200;

    @Override
    public int getI() { return this.i; }
}

class TestParent{

    private int i = 100;

    public int getI() { return this.i; }

    public void printName(){
        System.err.println( this.getClass().getName() );
        System.err.println( this.getI() ); // this will print 200
    }
}