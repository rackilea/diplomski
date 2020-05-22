public interface Observer {
  public void receiveEvent(Observable source, Event event);
}

public interface Observable {
  public void addObserver(Observer observer);
  public void removeObserver(Observer observer);
  public Collection<Observer> getObservers();

  default public void notifyAllObservers(Event event) {
    for (Observer observer : this.getObservers()) {
      observer.receiveEvent(this, event);
    }
  }
}

public interface Event { }

public abstract class AbstractObservableImpl implements Observable {
  private Set<Observer> observers = new HashSet<>();

  @Override
  public final void addObserver(final Observer observer) {
      this.observers.add(observer);
  }

  @Override
  public final void removeObserver(final Observer observer) {
    this.observers.remove(observer);
  }

  @Override
  public final Collection<Observer> getObservers() {
    return Collections.unmodifiableCollection(this.observers);
  }
}

public class Sender extends AbstractObservableImpl { }

public class Group extends AbstractObservableImpl implements Observer {
  private List<Sender> senders = new ArrayList<>();

  @Override
  public final void receiveEvent(final Observable source, final Event event) {
    for (Observer observer : this.getObservers()) {
      observer.receiveEvent(this, event);
    }
  }

  public final void addSender(Sender sender) {
    if (this.senders.contains(sender) == false) {
      this.senders.add(sender);
    }
    this.senders.get(this.senders.indexOf(sender)).addObserver(this);
  }

  public final void removeSender(Sender sender) {
    final int index = this.senders.indexOf(sender));
    if (index >= 0)  {
      this.senders.get(index).removeObserver(this);
    }
    this.senders.remove(sender);
  }
}