public class MyClass {
    private int myInt;
    public void setMyInt( int i ) { this.myInt = i; }
    public int getMyInt() { return this.myInt; }

    public void addsTo( int add ) { return myInt + add; }
    ...
}


public class TestMyClass {
    MyClass my = new MyClass();
    @Before public void setup() { my.setMyInt( 42 ); }
    @Test public void testIs42() { assertEqual( "MyInt is 42" , my.getMyInt() , 42 ); }
    @Test public void testAddsTo() { assertEqual( "addsTo() works" , my.addsTo( 10 ) , 52 ); }
}