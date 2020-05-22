public class ReadFile extends Observable 
{
    public void readFile()
    {
        // ...
        // After reading file.
        notifyObservers();
    }
}