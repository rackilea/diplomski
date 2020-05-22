class AClass extends Q implements T
{

    class B extends Z
    {
        boolean CargoAttached;

        public B()
        {

        }

        public B(Z z)
        {
            CargoAttached = false;
        }

        public void D(int A, int B)
        {
        }
    }

    private Z z = new Z();

    void C()
    {
        z = (new B(z));
        ((B) z).D(1, 2);
    }
}