public class A 
{
    public void someMethod () {}

    public class B
    {
        public void someMethod () {}

        public void someOtherMethod ()
        {
            A.this.someMethod (); // invokes someMethod of the class A instance that
                                  // encloses this B instance

            A.class.getName (); // invokes the getName method of the Class class
        }
    }

}