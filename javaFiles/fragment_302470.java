public class LeakFactory
{//Just so that we have some data to leak
    int myID = 0;
// Necessary because our Leak class is an Inner class
    public Leak createLeak()
    {
        return new Leak();
    }

// Mass Manufactured Leak class
    public class Leak
    {//Again for a little data.
       int size = 1;
    }
}