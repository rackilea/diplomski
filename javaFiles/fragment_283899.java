class B extends A
{
    int x = 6;

    @Override
    void foo()
    {
        System.out.println(this.x);
    }
}