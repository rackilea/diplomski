public interface Observer
{
    public void update(ArrayList<Integer> list);    
}

public interface Observable
{
    public void register(Observer o);
    public void unregister(Observer o);
    public void notifyObservers();
}