@SuppressWarnings("unchecked")
public synchronized void notifyObservers(T message) {
    Object[] observerArray = observers.toArray();
    for (Object observer : observerArray)
        ((Observer<T>) observer).notify(message);
}