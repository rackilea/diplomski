public class SomeClass()
{
    private abstract class BasicStuff
    {
        // All code that is the same in all implementations go here
        void method1() { /* do something that is always the same */ }

        // All code that shall be different in all implementations go here
        abstract void method2();
    }

    private final BasicStuff whatShallWeDoToday;

    public SomeClass(int param)
    {
        switch (param)
        {   // construct anonymous class with functionallity of ClassA
            case 1: whatShallWeDoToday = new StuffInterface()
                    {
                        void method2() { /* something */ }
                    }
                    break;

            // construct anonymous class with functionallity of ClassB
            case 2: whatShallWeDoToday = new StuffInterface()
                    {
                        void method2() { /* something else */ }
                    }
                    break;

            default:throw IllegalArgumentException();
        }
    }

    public runMethod1()
    { 
        whatShallWeDoToday.method1();
    }

    public runMethod2()
    { 
        whatShallWeDoToday.method2();
    }
}