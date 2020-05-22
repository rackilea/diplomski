class Main
{
    public static void main(String[] arg)
    {
        C c = new C();

        c.show(); //how to access class A
    }

}

class A
{
    void show()
    {
        System.out.println("inside A");
    }
}

class B extends A
{
    void show()
    {
        System.out.println("inside B");
    }

    void showA()
    {
        super.show();
    }
}

class C extends B
{
    void show()
    {
        super.showA(); // Calls A
        System.out.println("inside C");
    }
}