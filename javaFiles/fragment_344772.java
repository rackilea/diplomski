public class PutController
{ 
...
    public PutController getElement (int i)
    {
        if (i < 0 || i >= putControllerArray.length) {
            // TODO throw some exception
        }
        return putControllerArray[i];
    }
...
}