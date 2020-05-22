import java.util.ArrayList;
import java.util.List;


public class Observable implements IObservable
{
        private List<IObserver> observers;

        @Override
        public synchronized void addObserver(IObserver o)
        {
                if (observers == null)
                {
                        observers = new ArrayList<IObserver>();
                }
                else if (observers.contains(o))
                {
                        return;
                }
                observers.add(o);
        }

        @Override
        public synchronized void deleteObserver(IObserver o)
        {
                if (observers == null)
                {
                        return;
                }
                int idx = observers.indexOf(o);
                if (idx != -1)
                {
                        observers.remove(idx);
                }
        }

        @Override
        public synchronized void notifyObservers(INotification notification)
        {
                if (observers == null)
                {
                        return;
                }
                for (IObserver o : observers)
                {
                        o.update(notification);
                }
        }

}