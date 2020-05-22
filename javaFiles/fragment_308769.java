public class A1 extends A
{

    public static class Builder extends A.Builder<A1, A1.Builder>
    {

        public Builder()
        {
            this.a = new A1();
        }

        @Override
        public A1 build()
        {
            return this.a;
        }


        @Override
        public A1.Builder getBuilder()
        {
            return this;
        }
    }
}