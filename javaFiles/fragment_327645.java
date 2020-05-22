public class Observable<U> {

       private List<Observer<U>> _observers =
               new ArrayList<Observer<U>>();

       public void addObserver(Observer<U> obs) {
           if (obs == null) {
               throw new IllegalArgumentException();
           }
           if (_observers.contains(obs)) {
              return;
           }
           _observers.add(obs);            }

       public void notifyObservers(U data) {
           for (Observer<U> obs : _observers) {
               obs.atualizar(this, data);
           }
       }
   }

   interface Observer<U> {
       public void atualizar(Observable<U> entity, U arg);
   }