import java.util.WeakHashMap;

public class WeakRunnableList
{
    private WeakHashMap<Runnable, Void> _items = new WeakHashMap<Runnable, Void>();

    public void Add(Runnable r)
    {
        _items.put(r, null);
    }

    public void Execute()
    {
        Iterator<Runnable> iterator = _items.keySet().iterator();
        while (iterator.hasNext()) {
            Runnable runnable = iterator.next();
            if (runnable != null) {
                runnable.run();
                iterator.remove();
            }
        }
    }
}