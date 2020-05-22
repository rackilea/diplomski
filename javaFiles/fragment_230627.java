class X extends A implements B
    {
    }

    class A
    {
        public Enumeration<Long> test(){return null;}
    }

    class C
    {
        public Enumeration<String> test(){return null;}
    }

    //This doesn't compile! String does not extend Number
    /*class Y extends C implements B
    {
    }*/

    interface B
    {
        public Enumeration<? extends Number> test();
    }