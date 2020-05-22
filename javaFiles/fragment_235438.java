final class Demo
{
    private final int x;
    private static final int z;  //must be initialized here.

    static 
    {
        z = 10;  //It can be initialized here.
    }

    public Demo(int x)
    {
        this.x=x;  //This is possible.
        //z=15; compiler-error - can not assign a value to a final variable z
    }
}