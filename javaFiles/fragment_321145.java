class Example
{
    static int i= 5;
        static
        {
                System.out.println("Example Loaded");
        }
        Example()
        {
                System.out.println("Example Constructed");
        }
}

public static void main(String[] args) {
    Class c = Example.class;
    Constructor[] con = c.getDeclaredConstructors();
    for(Constructor x: con)
    {
            System.out.println("Hello "+x.getName());

    }
    System.out.println(Example.i);

}