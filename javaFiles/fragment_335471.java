class ABC
{
    int instance_var; // instance variable
    static int static_var; // class variable
}

class ABC_Invoker
{
    public static void main(string[] args)
    {
        ABC obj1 = new ABC();
        ABC obj2 = new ABC();

        obj1.instance_var = 10;
        obj2.instance_var = 20;

        ABC.static_var = 50; // See, you access static member by it's class name

        System.out.prinln(obj1.instance_var);
        System.out.prinln(obj2.instance_var);
        System.out.prinln(ABC.static_var);
        System.out.prinln(obj1.static_var); // Wrong way, but try it
        System.out.prinln(obj2.static_var); // Wrong way, but try it
    }
}