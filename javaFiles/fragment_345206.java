class Bar extends Foo 
{
    public Bar () {
        super (doSmth(this));
        ...
    }

    private static String doSmth (Bar bar) {
        //what I can NOT do here?
   }
}