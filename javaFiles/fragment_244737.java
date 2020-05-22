class uncheckedreturn
{
    static abstract class Abstract<A extends Abstract<?>>
    {
        abstract public A make();
    }

    static class ConcreteA extends Abstract<ConcreteA>
    {
        @Override
        public ConcreteA make()
        {
            return new ConcreteA();
        }

    }

    static class ConcreteB extends Abstract<ConcreteB>
    {
        @Override
        public ConcreteB make()
        {
            return new ConcreteB();
        }
    }

//    // Now, this is no longer possible:
//    static class ConcreteB extends Abstract<ConcreteB>
//    {
//        @Override
//        public ConcreteA make()
//        {
//            return new ConcreteA();
//        }
//    }

    // But this still IS possible, but may also not be desired...
    static class ConcreteC extends Abstract<ConcreteA>
    {
        @Override
        public ConcreteA make()
        {
            return new ConcreteA();
        }
    }


    public static void main(String[] args)
    {
        ConcreteA a0 = new ConcreteA();
        ConcreteA ma0 = a0.make();

        ConcreteB b0 = new ConcreteB();
        ConcreteB mb0 = b0.make();
    }
}