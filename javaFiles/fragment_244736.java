class uncheckedreturn
{
    static abstract class Abstract
    {
        abstract public Abstract make();
    }

    static class ConcreteA extends Abstract
    {
        @Override
        public ConcreteA make()
        {
            return new ConcreteA();
        }

    }

    static class ConcreteB extends Abstract
    {
        @Override
        public ConcreteB make()
        {
            return new ConcreteB();
        }
    }

    public static void main(String[] args)
    {
        ConcreteA a0 = new ConcreteA();
        ConcreteA ma0 = a0.make();

        ConcreteB b0 = new ConcreteB();
        ConcreteB mb0 = b0.make();

    }

    // This is possible, but you'd like to not allow this
    static class ConcreteC extends Abstract
    {
        @Override
        public ConcreteA make()
        {
            return new ConcreteA();
        }
    }

}