public class Alpha
{
    public boolean theVariable = true;

    public class Beta
    {
       // Perform an action
       public void doSomething() {
           theVariable = false; // Should now be ok
       }
    }

    public Beta b;

    // constructor
    public Alpha() {
        b = new Beta();
    }

    // do something with Beta
    public void doSomethingWithBeta() {
        b.doSomething();
    }
}