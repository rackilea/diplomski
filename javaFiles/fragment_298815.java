public class Foo {
    private static int a;
    private int b;
    public void setMethod(int a){
       //Do something with static a and parameter a for example 
       b = Foo.a + a;
    }
}